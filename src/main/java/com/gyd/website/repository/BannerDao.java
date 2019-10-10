package com.gyd.website.repository;

import com.gyd.website.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerDao extends JpaRepository<Banner,Long> {
    List<Banner> findBannerByTypeEquals(Integer type);


}
