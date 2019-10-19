package com.uino.javalearn.lambda;

import java.awt.event.ActionListener;
import java.util.function.*;

public class LambdaLearn1 {
    public static void lambdaWrite(){
        //不带参数
        Runnable noArguments=()-> System.out.println("hello world noArguments");
        //省略参数类型
        ActionListener oneArguments= event-> System.out.println("hello world oneArguments");
        //代码块
        Runnable multiStatement=()->{
            System.out.println("hello world multiStatement");
            System.out.println("hello world multiStatement");
        };
        BinaryOperator<Long> add=(x, y)->x+y;
        BinaryOperator <Long> addExplicit=(Long x,Long y)->x+y;
    }

    public static void lambdaDemo(){
        Predicate<String> predicate=str-> str.equals("hello world");
        System.out.println(predicate.test("111"));
        Consumer<String> consumer=str-> System.out.println("hello world");
        consumer.accept("111");
        Function<String,Integer> function=str->str.length();
        System.out.println(function.apply("helloworld"));
        Supplier<String> supplier=()->"hello world";
        System.out.println(supplier.get());
        UnaryOperator <String> unaryOperator=str->str;
        System.out.println(unaryOperator);
        BinaryOperator <String> binaryOperator=(str,str1)->"helloworld";
//        System.out.println(binaryOperator.);
    }

    public static void main(String []args){
        lambdaDemo();
    }
}
