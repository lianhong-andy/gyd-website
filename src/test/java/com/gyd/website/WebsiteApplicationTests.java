package com.gyd.website;

import cn.hutool.core.lang.Dict;
import cn.hutool.core.util.StrUtil;
import com.gyd.website.model.Banner;
import com.gyd.website.model.GydMenu;
import com.gyd.website.repository.BannerDao;
import com.gyd.website.repository.IndexDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebsiteApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private IndexDao indexDao;

    @Autowired
    private BannerDao bannerDao;
    @Test
    public void test1(){
        List<GydMenu> list = indexDao.findByParentIdEqualsOrderBySortDesc(0L);
        System.out.println("StrUtil.toString(list) = " + StrUtil.toString(list));
        Banner banner = new Banner();
        banner.setType(0);
        Example<Banner> example = Example.of(banner);
        Pageable sort = PageRequest.of(0,2,Sort.Direction.DESC,"sort");
        Pageable page = PageRequest.of(0,2);
        Page<Banner> indexBanner = bannerDao.findAll(example, sort);
        List<Banner> indexBanners = bannerDao.findByTypeEquals(0,sort);
        List<Banner> pages = bannerDao.findByTypeEquals(0,page);
        List<Banner> pages2 = bannerDao.findByTypeEquals(0,page);
    }

}
