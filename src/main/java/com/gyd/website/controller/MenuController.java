package com.gyd.website.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.gyd.website.pojo.vo.GydMenuVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lianhong
 * @description 菜单
 * @date 2019/10/22 0022上午 9:20
 */
@RestController
public class MenuController {
    @GetMapping("/menu")
    @ResponseBody
    public String getMenuList(HttpServletRequest request) {
        List<GydMenuVo> menuListVo = new ArrayList<>();
        if (ObjectUtil.isNotNull(request.getAttribute("menuListVo"))) {
            menuListVo.addAll((List<GydMenuVo>)request.getAttribute("menuListVo"));
        }
        return StrUtil.toString(menuListVo);
    }
}
