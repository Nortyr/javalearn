package com.uino.javalearn.annotation.controller;

import com.uino.javalearn.annotation.AnnotationDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 陈晖
 * @Date: Create in 下午 4:27 2019/10/10 0010
 * @Descroption:
 */

@RestController
public class TestController {

    @RequestMapping("/annotation")
    @AnnotationDemo()
    public String annotationTest(String name,String sex){
        return "aaaaa";
    }

}
