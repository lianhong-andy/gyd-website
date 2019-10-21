package com.gyd.website.repository;

import com.gyd.website.model.Banner;
import com.gyd.website.model.GydMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lianhong
 * @description
 * @date 2019/10/10 0010上午 9:12
 */
@Repository
public interface IndexDao extends JpaRepository<GydMenu,Long> {
    @Query(value = "select b1.* from banner b1 left join banner b2 on b1.parent_id = b2.id",nativeQuery = true)
    List<Banner> findAllMenus();

    List<GydMenu> findByParentIdEqualsOrderBySort(Long parentId);

}
