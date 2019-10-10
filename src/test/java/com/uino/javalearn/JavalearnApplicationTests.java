package com.uino.javalearn;

import com.uino.javalearn.annotation.AnnotationDemo;
import com.uino.javalearn.annotation.test.AnnotationTestDemo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavalearnApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void reflectTest() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//        AnnotationTestDemo annotationTestDemo= new AnnotationTestDemo();
        Class aClass=AnnotationTestDemo.class;
        Method method=aClass.getMethod("myMethods",String.class,String.class);
        AnnotationDemo annotationDemo=method.getAnnotation(AnnotationDemo.class);
        String name=annotationDemo.name();
        String sex=annotationDemo.sex();
        Object o=aClass.newInstance();
        method.invoke(o,name,sex);
    }
}
