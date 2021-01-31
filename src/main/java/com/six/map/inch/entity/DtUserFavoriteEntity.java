package com.six.map.inch.entity;

import com.six.map.common.entity.AutoBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@Table(name = "dt_user_favorite")
@ToString
@NoArgsConstructor
public class DtUserFavoriteEntity extends AutoBaseEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    /**
     * 用户 id
     */
    private Long userId;

    /**
     * 收藏内容的标题
     */
    private String title;

    /**
     * 收藏内容的原文地址，不带域名
     */
    private String lat;

    /**
     * 收藏内容的描述
     */
    private String description;

    /**
     * 收藏时间
     */
    private Integer createTime;

    /**
     *
     */
    
    private String lng;

    /**
     *
     */
    
    private String zoom;

    /**
     *
     */
    
    private Integer status;

    /**
     *
     */
    
    private String url;

    /**
     *
     */
    
    private Integer mapId;

    /**
     * 1:展示 0：隐藏
     */
    private String isShow;

    /**
     *
     */
    
    private String images;

    /**
     * 分类ID
     */
    private Integer interestType;


}
