package com.uino.javalearn.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
/**
 * @author: 陈晖
 * @Date: Create in 下午 4:47 2019/10/10 0010
 * @Descroption:
 */

@Aspect
@Component
public class TestAop {
    @Pointcut("@annotation(com.uino.javalearn.annotation.AnnotationDemo)")
    public void containsAnnotaion() {
    }


}
