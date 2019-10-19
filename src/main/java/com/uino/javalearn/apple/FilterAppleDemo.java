package com.uino.javalearn.apple;

import com.uino.javalearn.apple2.AppleGreenColorPredicate;
import com.uino.javalearn.apple2.AppleHeavyWeightPredicate;
import com.uino.javalearn.apple2.ApplePerdicate;

import java.util.ArrayList;
import java.util.List;

public class FilterAppleDemo {
    /**
     * 最传统的过滤,不好扩展，比如过滤红色苹果，这个方法又要复制一遍
     * @param inventory 原始数组
     * @return
     */
    public static List<Apple> filterGreenApple (List<Apple> inventory){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: inventory) {
            if("green".equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 针对上面的优化，颜色可变，但是不能区分重量等其他的
     * @param inventory 原始数组
     * @param color 改后数组
     * @return
     */
    public static List<Apple> filterGreenApple2 (List<Apple> inventory,String color){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: inventory) {
            if(color.equals(apple.getColor())){
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 可以判断是根据重量还是颜色区分，但是很笨重
     * @param inventory 原始数组
     * @param color 颜色参数
     * @param wight 重量参数
     * @param flag 标识以重量还是颜色判断
     * @return
     */
    public static List<Apple> filterGreenApple3 (List<Apple> inventory,String color,int wight,boolean flag){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: inventory) {
            if((flag&&color.equals(apple.getColor()))||(!flag&&wight<(apple.getWeight()))){
                list.add(apple);
            }
        }
        return list;
    }

    /**
     * 使用了策略模式，讲方法传递的方式，缺点：啰嗦
     * @param inventory
     * @param p
     * @return
     */
    public static List<Apple> filterGreenApple4 (List<Apple> inventory, ApplePerdicate p){
        List<Apple> list = new ArrayList<>();
        for (Apple apple: inventory) {
            if(p.test(apple)){
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args){
        List <Apple> list =new ArrayList<>();
        Apple apple=new Apple();
        apple.setColor("green");
        apple.setWeight(2);
        Apple apple2=new Apple();
        apple.setColor("red");
        apple.setWeight(2);
        list.add(apple);
        list.add(apple2);
        ApplePerdicate applePerdicate=new AppleGreenColorPredicate();
        ApplePerdicate applePerdicate1=new AppleHeavyWeightPredicate();
        filterGreenApple4(list,applePerdicate);

        filterGreenApple4(list, new ApplePerdicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });
        filterGreenApple4(list,apple1 -> "green".equals(apple1.getColor()));
    }
}
