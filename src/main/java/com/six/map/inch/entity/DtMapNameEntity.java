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
@Table(name = "dt_map_name")
@ToString
@NoArgsConstructor
public class DtMapNameEntity extends AutoBaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    /**
     * 中文名
     */
    private String name;

    /**
     * 网站标题
     */
    private String title;

    /**
     * 所需VIP等级
     */
    private Integer vipCount;

    /**
     *
     */
    private String type;

    /**
     * 地图类型名称
     */
    private String maptype;

    /**
     * 版权说明
     */
    private String attribution;

    /**
     * 地图链接
     */
    private String urltemplate;

    /**
     * 地图参数
     */
    private String subdomains;

    /**
     * 路网链接
     */
    private String urltemplateRoad;

    /**
     * 路网参数
     */
    private String subdomainsRoad;

    /**
     * 实时交通链接
     */
    private String urltemplateTraffic;

    /**
     * 实时交通参数
     */
    private String subdomainsTraffic;

    /**
     * 排序等级
     */
    private Integer sort;

    /**
     *
     */
    private String projection;

    /**
     *
     */
    private Integer maxzoom;

    /**
     *
     */
    private Integer minzoom;

    /**
     * 滤镜
     */
    private String cssFilter;

    /**
     *
     */
    private Integer status;

    /**
     * 是否为默认地图
     */
    private Integer isDefault;

    /**
     * 地图图标
     */
    private String imgUrl;


}
