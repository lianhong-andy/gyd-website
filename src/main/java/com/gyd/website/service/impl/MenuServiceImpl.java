package com.gyd.website.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.gyd.website.model.GydMenu;
import com.gyd.website.pojo.vo.GydMenuVo;
import com.gyd.website.repository.MenuDao;
import com.gyd.website.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lianhong
 * @description
 * @date 2019/10/23 0023下午 1:41
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<GydMenuVo> getMenuInfoById(Long menuId) {
        List<GydMenuVo> menuVoList = new ArrayList<>();
        GydMenu gydMenu = menuDao.findById(menuId).get();
        if (ObjectUtil.isNotNull(gydMenu)) {
            Long parentId = gydMenu.getParentId();
            if (parentId.compareTo(0L) > 0) {
                menuVoList.addAll(this.getMenuInfoByParentId(parentId));
            } else {
                GydMenuVo gydMenuVo = new GydMenuVo();
                BeanUtil.copyProperties(gydMenu,gydMenuVo);
                menuVoList.add(gydMenuVo);
            }
        }

        return menuVoList;
    }

    @Override
    public List<GydMenuVo> getMenuInfoByParentId(Long menuId) {
        List<GydMenu> gydMenuList = menuDao.findByParentIdEqualsOrderBySort(menuId);
        List<GydMenuVo> menuVoList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(gydMenuList)) {
            List<GydMenuVo> menuList = gydMenuList.stream().map(gydMenu -> {
                GydMenuVo gydMenuVo = new GydMenuVo();
                BeanUtil.copyProperties(gydMenu,gydMenuVo);
                Long mid = gydMenuVo.getMenuId();
                List<GydMenu> subMenuList = new ArrayList<>();
                List<GydMenu> subMenus = menuDao.findByParentIdEqualsOrderBySort(mid);
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

        return menuVoList;
    }
}
