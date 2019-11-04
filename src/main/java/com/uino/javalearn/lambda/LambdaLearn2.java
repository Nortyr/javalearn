package com.uino.javalearn.lambda;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LambdaLearn2 {
    public static void main(String []args){
        lambdaDemo1();
    }

    private static void lambdaDemo1() {
        Student student=new Student();
        Student student1=new Student();
        Student student2=new Student();
        Student student3=new Student();
        Student student4=new Student();
        student.setName("张三");
        student.setClassname("高三一");
        student.setScored(100);
        student.setWeight(80.1);
        student.setSex("女");
        student1.setSex("男");
        student1.setName("李四");
        student1.setClassname("高三一");
        student1.setScored(90);
        student1.setWeight(60.3);
        student1.setSex("男");
        student2.setName("小红");
        student2.setClassname("高三一");
        student2.setScored(95);
        student2.setWeight(50);
        student2.setSex("女");
        student3.setName("王五");
        student3.setClassname("高三二");
        student3.setScored(100);
        student3.setWeight(80.1);
        student3.setSex("男");
        student4.setName("赵六");
        student4.setClassname("高三三");
        student4.setScored(100);
        student4.setWeight(80.1);
        student4.setSex("男");
        List<Student> list =new ArrayList<>();

        list.add(student);
        list.add(student);
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        /////////////////
//        int su=list.stream().collect(reducing(0,Student::getScored,Integer::sum));
        Map<String, Set<Student>>maps=list.stream().collect(groupingBy(Student::getSex, Collectors.toSet()));
        System.out.println(maps);
        Map<StudentEasy,List<Student>>maps2=list.stream().collect(groupingBy(t->new StudentEasy(t.getName(),t.getSex())));
        System.out.println(maps2);
        Map<String, Set<Student>>maps3=list.stream().collect(groupingBy(Student::getSex, LinkedHashMap::new, Collectors.toSet()));
        System.out.println(maps3);
    }
}
