package com.gyd.website.pojo.vo;

import com.gyd.website.model.GydMenu;
import lombok.Data;

import java.util.List;

/**
 * @author lianhong
 * @description
 * @date 2019/10/12 0012下午 1:34
 */
@Data
public class GydMenuVo extends GydMenu {
    private List<GydMenu> subMenuList;
}
