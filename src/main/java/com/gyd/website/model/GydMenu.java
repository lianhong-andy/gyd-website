package com.gyd.website.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author lianhong
 * @description
 * @date 2019/10/10 0010上午 9:11
 */
@Data
@Entity
@Table(name = "gyd_menu")
public class GydMenu implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long menuId;
    @Column(name = "name")
    private String name;
    @Column(name = "value")
    private String value;
    @Column(name = "img_url")
    private String img_url;
    @Column(name = "url")
    private String url;
    @Column(name = "type")
    private Integer type;
    @Column(name = "show_pc")
    private Integer showPc;
    @Column(name = "show_wap")
    private Integer showWap;
    @Column(name = "sort")
    private Integer sort;
    @Column(name = "show_wxapp")
    private Integer showWxApp;
    @Lob
    @Column(name = "description", columnDefinition="TEXT")
    private String description;
    @Column(name = "parent_id")
    private Long parentId;


}
