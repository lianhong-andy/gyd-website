package com.gyd.website.pojo.vo;

import com.gyd.website.model.Banner;
import com.gyd.website.model.GydMenu;
import lombok.Data;

import java.util.List;

/**
 * @author lianhong
 * @description 首页
 * @date 2019/10/12 0012下午 1:09
 */
@Data
public class IndexVo {
    private List<GydMenuVo> menuList;
    private List<Banner> bannerList;
}
