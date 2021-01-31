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
@Table(name = "dt_user")
@ToString
@NoArgsConstructor
public class DtUserEntity extends AutoBaseEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "JDBC")
    private Long id;

    /**
     * 用户类型;1:admin;2:会员
     */
    private Integer userType;

    /**
     * 性别;0:保密,1:男,2:女
     */
    private Integer sex;

    /**
     * 生日
     */
    private Integer birthday;

    /**
     * 最后登录时间
     */
    private Integer lastLoginTime;

    /**
     * 用户积分
     */
    private Integer score;

    /**
     * 金币
     */
    private Integer coin;

    /**
     * 注册时间
     */
    private Integer createTime;

    /**
     * 用户状态;0:禁用,1:正常,2:未验证
     */
    private Integer userStatus;

    /**
     * 用户名
     */
    private String userLogin;

    /**
     * 登录密码;cmf_password加密
     */
    private String userPass;

    /**
     * 用户昵称
     */
    private String userNickname;

    /**
     * 用户登录邮箱
     */
    private String userEmail;

    /**
     * 用户个人网址
     */
    private String userQq;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 最后登录ip
     */
    private String lastLoginIp;

    /**
     * 激活码
     */
    private String userActivationKey;

    /**
     * 用户手机号
     */
    private String mobile;

    /**
     * 扩展属性
     */
    private String more;

    /**
     * 会员到期时间
     */
    private Integer viptime;

    /**
     * 家乡
     */
    private String province;

    /**
     *
     */
    private String city;

    /**
     *
     */
    private String district;

    /**
     *
     */

    private Integer isvip;

    /**
     * 是否兑换过一天VIP
     */
    private Integer isConvert;

    /**
     *
     */

    private String userUrl;

    /**
     * ios用户绑定的账号
     */
    private Integer bindId;

    /**
     *
     */

    private Integer isEs;


}
