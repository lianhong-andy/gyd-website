package com.gyd.website.controller;

import cn.hutool.core.util.ObjectUtil;
import com.gyd.website.model.Banner;
import com.gyd.website.pojo.vo.GydMenuVo;
import com.gyd.website.pojo.vo.IndexVo;
import com.gyd.website.repository.BannerDao;
import com.gyd.website.repository.MenuDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lianhong
 * @description
 * @date 2019/9/18 0018下午 7:39
 */
@RestController
@Slf4j
public class IndexController {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private BannerDao bannerDao;
    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/index");
        IndexVo indexVo = new IndexVo();
        List<GydMenuVo> menuVoList = new ArrayList<>();
        if(ObjectUtil.isNotNull(request.getAttribute("menuListVo"))) {
            menuVoList.addAll((List<GydMenuVo>) request.getAttribute("menuListVo"));
        }
        Banner banner = new Banner();
        banner.setType(0);
        Example<Banner> example = Example.of(banner);
        Pageable sort = PageRequest.of(0,2,Sort.Direction.DESC,"sort");
        Page<Banner> indexBanner = bannerDao.findAll(example, sort);
        indexVo.setMenuList(menuVoList);
        indexVo.setBannerList(indexBanner.getContent());
        mv.addObject(indexVo);
        return mv;
    }
}
