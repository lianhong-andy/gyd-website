package com.gyd.website.service;

import com.gyd.website.pojo.vo.GydMenuVo;

import java.util.List;

public interface MenuService {
    /**
     * 根据菜单id获取菜单信息
     * @param menuId
     * @return
     */
    List<GydMenuVo> getMenuInfoById(Long menuId);

    /**
     * 根据父类菜单id获取菜单信息
     * @param menuId
     * @return
     */
    List<GydMenuVo> getMenuInfoByParentId(Long menuId);
}
