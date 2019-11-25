package com.uino.javalearn.lambda;

import java.util.*;

import static java.util.stream.Collectors.*;


public class LambdaLearn4 {
    public static void main(String []args){
        lambdaDemo10();
    }

    private static void lambdaDemo10() {
        List<Student> list =getList();
        System.out.println(list.stream().collect(mapping(Student::getScored,toList())));;
        System.out.println(list.stream().collect(() -> new HashMap<>(), (a,b)->a.put(b.getScored(),b),Map::putAll));
        System.out.println(list.stream().collect(groupingBy(Student::getScored,mapping(Student::getName,toList()))));
        System.out.println(list.stream().collect(groupingBy(Student::getScored,groupingBy(Student::getSex))));
    }

    private static void lambdaDemo9() {
        List<Student> list =getList();
        Map<String,Integer>m=list.stream().collect(toMap(Student::getName,Student::getScored,(a, b)->b));
        System.out.println(m);
    }

    private static void lambdaDemo8() {
        List<Student> list =getList();
        Map<String, Set<Student>> s=list.stream().collect(groupingBy(Student::getSex, toSet()));
        System.out.println(s);
        Map<String, Set<Student>> s1=list.stream().collect(groupingBy(Student::getSex,HashMap::new, toSet()));
        System.out.println(s1);
        Map<Boolean, Set<Student>> s2=list.stream().collect(groupingBy(t->{return t.getSex().equals("男");},HashMap::new, toSet()));
        System.out.println(s2);
    }

    private static void lambdaDemo7() {
        List<Student> list =getList();
        Optional student=list.stream().collect(reducing((a, b)->b));
        System.out.println(student);
        Student c=list.stream().collect(reducing(null,(a, b)->b));
        System.out.println(c);
    }

    private static void lambdaDemo6() {
        List<Student> list =getList();
        Integer i=list.stream().collect(summingInt(t->t.getScored()));
        System.out.println(i);
    }

    private static void lambdaDemo5() {
        List<Student> list =getList();
        Optional o=list.stream().collect(maxBy(Comparator.comparingInt(Student::getScored)));
        System.out.println(o);
    }

    private static void lambdaDemo4() {
        List<Student> list =getList();
        Long l=list.stream().collect(counting());
        System.out.println(l);
    }

    private static void lambdaDemo3() {
        List<Student> list =getList();
        Student student=list.stream().collect(collectingAndThen(maxBy((a, b)->a.getScored()-b.getScored()),Optional::get));
        System.out.println(student);
    }

    private static void lambdaDemo2() {
        List<Student> list =getList();
//        Set<String> sets=list.stream().collect(Collectors.mapping(Collectors.maxBy((a,b)->)));
    }

    private static void lambdaDemo1() {
//        String lists= Stream.of("a","b").collect(Collectors.joining());
//        System.out.println(lists);
    }

    public static List<Student> getList(){
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
        return list;
    }
}
