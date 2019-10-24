package com.gyd.website.controller;

import cn.hutool.core.util.ObjectUtil;
import com.gyd.website.model.GydMenu;
import com.gyd.website.pojo.vo.GydMenuVo;
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

/**
 * @author lianhong
 * @description 公司介绍
 * @date 2019/10/21 0021下午 1:20
 */
@RestController
@Slf4j
public class IntroduceController {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private MenuService menuService;
    @GetMapping("/introduce/info/{menuId}")
    public ModelAndView introduceInfo(HttpServletRequest request, @PathVariable Long menuId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/introduction/simpleIntroduce");
        List<GydMenuVo> menuVoList = new ArrayList<>();
        if (ObjectUtil.isNotNull(request.getAttribute("menuListVo"))) {
            menuVoList = (List<GydMenuVo>) request.getAttribute("menuListVo");
        }
        List<GydMenuVo> introduceInfos = menuService.getMenuInfoById(menuId);
        GydMenu gydMenu = menuDao.findById(menuId).get();
        mv.addObject("leftMenus",introduceInfos);
        mv.addObject("menuVo",menuVoList);
        mv.addObject("menu",gydMenu);

        return mv;
    }
}
