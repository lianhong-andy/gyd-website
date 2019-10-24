package com.gyd.website.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.gyd.website.model.GydMenu;
import com.gyd.website.pojo.vo.GydMenuVo;
import com.gyd.website.repository.BannerDao;
import com.gyd.website.repository.MenuDao;
import com.gyd.website.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lianhong
 * @description
 * @date 2019/10/17 0017上午 9:36
 */
@RestController
@Slf4j
public class RecruitmentController {
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private BannerDao bannerDao;
    @Autowired
    private MenuService menuService;
    @GetMapping("/recruit/info/{menuId}")
    public ModelAndView recruitmentInfo(HttpServletRequest request,@PathVariable Long menuId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/recruitment/recruitment");
        List<GydMenuVo> menuVoList = new ArrayList<>();
        if(ObjectUtil.isNotNull(request.getAttribute("menuListVo"))) {
            menuVoList.addAll((List<GydMenuVo>) request.getAttribute("menuListVo"));
        }
        List<GydMenuVo> recruitInfos = menuService.getMenuInfoById(menuId);
        GydMenu gydMenu = menuDao.findById(menuId).get();
        mv.addObject("leftMenus",recruitInfos);
        mv.addObject("menuVo",menuVoList);
        mv.addObject("menu",gydMenu);
        return mv;
    }
}
