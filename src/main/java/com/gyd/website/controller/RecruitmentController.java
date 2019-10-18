package com.gyd.website.controller;

import com.gyd.website.model.GydMenu;
import com.gyd.website.repository.IndexDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author lianhong
 * @description
 * @date 2019/10/17 0017上午 9:36
 */
@RestController
@Slf4j
public class RecruitmentController {
    @Autowired
    private IndexDao indexDao;
    @GetMapping("/recruit/info/{menuId}")
    public ModelAndView recruitmentInfo(HttpServletRequest request,@PathVariable Long menuId) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("page/recruitment/recruitment");
        GydMenu incruitMent = indexDao.findById(menuId).get();
        mv.addObject("incruitMent",incruitMent);
        return mv;
    }
}
