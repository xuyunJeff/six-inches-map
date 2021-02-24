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
@Table(name = "dt_app_version")
@ToString
@NoArgsConstructor
public class DtAppVersionEntity extends AutoBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    /**
     * 版本号
     */
    private String version;

    /**
     *
     */
    private Integer versionCode;

    /**
     * 描述
     */
    private String descript;

    /**
     * 下载链接
     */
    private String updateLink;

    /**
     * 苹果链接
     */
    private String osLink;

    /**
     * 是否强制更新
     */
    private Integer isHot;

    /**
     *
     */
    private Integer latest;

    /**
     *
     */
    private Integer status;


}
