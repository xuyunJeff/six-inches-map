package com.six.map.common.annotation;



import com.six.map.common.constant.ExcelType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 小懒虫
 * @date 2018/12/14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface Excel {
    // 字段标题名称或文件名称
    String value();
    // excel操作类型ExcelType
    ExcelType type() default ExcelType.ALL;
    // 字段字典标识，用于导入导出时进行字典转换（只支持导出操作）
    String dict() default "";
    // 关联操作实体对象字段名称，用于获取关联数据（只支持导出操作）
    String joinField() default "";
}
