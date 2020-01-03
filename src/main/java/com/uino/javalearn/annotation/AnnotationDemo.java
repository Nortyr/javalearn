package com.uino.javalearn.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: 陈晖
 * @Date: Create in 下午 4:26 2019/10/10 0010
 * @Descroption:
 */
@Target(value={ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationDemo {
    String name() default "zhangsan";
    String sex() default "nan";
}
