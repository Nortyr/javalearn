package com.uino.javalearn.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaLearn3 {
    public static void main(String []args){
        lambdaDemo10();
    }

    private static void lambdaDemo10() {
        List<Student> list =getList();
        List<Student> lists=list.stream().collect(ArrayList::new,ArrayList::add,(a,b)->a.addAll(b));
        System.out.println(lists);
    }

    private static void lambdaDemo9() {
        List<Student> list =getList();
        Optional o=list.stream().reduce((a, b)->a);
        Student student= (Student) o.get();
        System.out.println(student);
        System.out.println(o);
        Student s=list.stream().reduce(null,(a, b)->{
            System.out.println("aaa"+a);
            System.out.println("bbb"+b);
            return b;
        });
        System.out.println(s);
        //Student reduce = list.stream().reduce(Student::new, (a, b) -> a);

    }

    private static void lambdaDemo8() {
        List<Student> list =getList();
        Student[] lists=list.stream().toArray(Student[]::new);
        System.out.println(lists);
    }


    /**
     * forEach终止操作
     */
    private static void lambdaDemo7() {
        List<Student> list =getList();
        list.stream().forEach(System.out::println);
        list.stream().forEachOrdered(System.out::println);
    }

    /**
     * limit限制多少个
     * skip跳过多少个
     */
    private static void lambdaDemo6() {
        List<Student> list =getList();
        Long lists=list.stream().map(t->t.getName()).limit(3).count();
        Long lists2=list.stream().map(t->t.getName()).skip(3).count();
        System.out.println(lists);
        System.out.println(lists2);

    }

    /**
     * peek:debug使用
     */
    private static void lambdaDemo5() {
        List<Student> list =getList();
        List <String> lists=list.stream().peek(System.out::println).map(t->t.getName()).peek(System.out::println).collect(Collectors.toList());
        System.out.println(lists);
    }

    /**
     * sorted排序
     *
     */
    private static void lambdaDemo4() {
        List<Student> list =getList();
//        List <Student> lists=list.stream().sorted().collect(Collectors.toList());
//        System.out.println(lists);
        List <Student> lists2=list.stream().sorted((a,b)->a.getScored()-b.getScored()).collect(Collectors.toList());
        System.out.println(lists2);
    }

    /**
     * 去重返回一个新值
     */
    private static void lambdaDemo3() {
        List<Student> list =getList();
        Long i=list.stream().distinct().count();
        System.out.println(i);
    }

    /**
        map:给每个成员执行一个方法
        Function t->return R
        flatMap t->streamw
     */
    private static void lambdaDemo2() {
        List<Student> list =getList();
        List <String> lists=list.stream().map(t->t.getName()).collect(Collectors.toList());
        System.out.println(lists);
        List <String> lists1=list.stream().flatMap(t-> Stream.of(t.getName())).collect(Collectors.toList());
        System.out.println(lists1);
    }

    /**
    filter:接受一个谓词
    Predicate t->return boolean
     */
    private static void lambdaDemo1() {
        List<Student> list =getList();
        List <Student> lists=list.stream().filter(t->t.getSex().equals("男")).collect(Collectors.toList());
        System.out.println(lists);
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
