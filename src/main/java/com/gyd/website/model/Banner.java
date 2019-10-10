package com.gyd.website.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @author lianhong
 * @description 首页轮播图
 * @date 2019/10/10 0010上午 9:27
 */
@Data
@Entity
@Table(name = "banner")
public class Banner {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "img")
    private String img;
    @Column(name = "type")
    private Integer type;
    @Column(name = "sort")
    private Integer sort;
}
