package com.gyd.website.controller;

import com.gyd.website.model.Banner;
import com.gyd.website.model.GydMenu;
import com.gyd.website.repository.BannerDao;
import com.gyd.website.repository.IndexDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    private IndexDao indexDao;
    @Autowired
    private BannerDao bannerDao;
    @GetMapping(value = {"", "/"})
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/index");
        List<GydMenu> gydMenuList = indexDao.findAll();
        List<Banner> indexBanner = bannerDao.findBannerByTypeEquals(0);
        mv.addObject(gydMenuList);
        mv.addObject(indexBanner);
        Banner banner = new Banner();
        banner.setType(0);
        Example<Banner> example = Example.of(banner);
        Pageable sort = PageRequest.of(0,3,Sort.Direction.DESC,"sort");
        Page<Banner> all = bannerDao.findAll(example, sort);
        System.out.println("all = " + all.toString());
        return mv;
    }
}
