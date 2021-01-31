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
@Table(name = "dt_draw_collection")
@ToString
@NoArgsConstructor
public class DtDrawCollectionEntity extends AutoBaseEntity {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     *
     */
    private Integer mapid;

    /**
     * 类型
     */
    private String type;

    /**
     * json数据
     */
    private String json;

    /**
     *
     */
    private Integer zindex;

    /**
     * 标题
     */
    private String title;

    /**
     * 描述
     */
    private String des;

    /**
     * 经纬度
     */
    private String lat;

    /**
     * 经纬度
     */
    private String lng;

    /**
     *
     */
    private String titleArr;

    /**
     *
     */
    private String desArr;

    /**
     * 添加时间
     */
    private Integer addTime;


}
