package com.gyd.website.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.gyd.website.model.GydMenu;
import com.gyd.website.pojo.vo.GydMenuVo;
import com.gyd.website.repository.IndexDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lianhong
 * @description 菜单拦截器
 * @date 2019/10/21 0021下午 1:28
 */
@Slf4j
@Component
public class MenuInterceptor implements HandlerInterceptor {
    @Autowired
    private IndexDao indexDao;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        List<GydMenu> gydMenuList = indexDao.findByParentIdEqualsOrderBySort(0L);
        List<GydMenuVo> menuVoList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(gydMenuList)) {
            List<GydMenuVo> menuList = gydMenuList.stream().map(gydMenu -> {
                GydMenuVo gydMenuVo = new GydMenuVo();
                BeanUtil.copyProperties(gydMenu,gydMenuVo);
                Long mid = gydMenuVo.getMenuId();
                List<GydMenu> subMenuList = new ArrayList<>();
                List<GydMenu> subMenus = indexDao.findByParentIdEqualsOrderBySort(mid);
                if (CollectionUtil.isNotEmpty(subMenus)) {
                    subMenuList.addAll(subMenus);
                }
                gydMenuVo.setSubMenuList(subMenuList);
                return gydMenuVo;
            }).collect(Collectors.toList());
            if (CollectionUtil.isNotEmpty(menuList)){
                menuVoList.addAll(menuList);
            }
        }
        request.setAttribute("menuListVo",menuVoList);
        return true;
    }

}
