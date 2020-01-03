package com.uino.javalearn.annotation.test;

import com.uino.javalearn.annotation.AnnotationDemo;

/**
 * @author: 陈晖
 * @Date: Create in 下午 4:31 2019/10/10 0010
 * @Descroption:
 */


public class AnnotationTestDemo {
    @AnnotationDemo()
    public void myMethods(String name,String sex){
        System.out.println(name+"......."+sex);
    }
}
