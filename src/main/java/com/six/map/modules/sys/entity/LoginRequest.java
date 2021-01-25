package com.six.map.modules.sys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * 系统用户
 *
 * @author ZhouChenglin
 * @email yczclcn@163.com
 * @url www.chenlintech.com
 * @date 2017年8月8日 下午2:42:32
 */
@Data
@ApiModel("用户登录")
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = 1L;



    /**
     * 用户名
     */
    @ApiParam("username")
    private String username;

    /**
     * 密码
     */
    @ApiParam("password")
    private String password;


}
