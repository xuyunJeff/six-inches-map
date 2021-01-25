package com.six.map.common.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Table;
import lombok.ToString;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@Table(name = "third_config")
@ToString
@NoArgsConstructor
@ApiModel("第三方配置")
public class ThirdConfigEntity extends AutoBaseEntity {
	
	/**
	 * 
	 */
	@ApiModelProperty("第三方服务器名")
	private String thirdName;
	
	/**
	 * 
	 */
	@ApiModelProperty("配置名")
	private String configName;
	
	/**
	 * 
	 */
	@ApiModelProperty("内容")
	private String jsonValue;
	

}
