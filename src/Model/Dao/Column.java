package Model.Dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义注解,描述属性-列对应关系
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Column {
	public String columnName() default "";  //表示数据库中表的字段名称
	public String type() default "";        //字段类型
	public boolean isKey() default false;   //字段是否为主键
} 
