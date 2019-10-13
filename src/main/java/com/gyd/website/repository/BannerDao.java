package com.gyd.website.repository;

import com.gyd.website.model.Banner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao extends JpaRepository<Banner,Long> {
    List<Banner> findBannerByTypeEquals(Integer type);

    List<Banner> findByTypeEquals(Integer type, Pageable page);
    List<Banner> findByTypeEqualsOrderBySortDesc(Integer type, Pageable page);


}
