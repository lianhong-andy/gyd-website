package com.gyd.website.config;

import com.gyd.website.pojo.vo.GydMenuVo;
import com.gyd.website.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lianhong
 * @description 菜单拦截器
 * @date 2019/10/21 0021下午 1:28
 */
@Slf4j
@Component
public class MenuInterceptor implements HandlerInterceptor {
    @Autowired
    private MenuService menuService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        List<GydMenuVo> menuVoList = menuService.getMenuInfoByParentId(0L);
        request.setAttribute("menuListVo",menuVoList);
        return true;
    }

}
