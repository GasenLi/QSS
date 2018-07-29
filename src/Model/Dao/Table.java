package Model.Dao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义注解,描述类-表对应关系
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
	public String tableName() default "";  //表示映射成数据库中表的名字
	public String ChineseDescribe() default "";
}
