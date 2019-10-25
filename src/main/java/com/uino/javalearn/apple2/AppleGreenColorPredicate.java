package com.uino.javalearn.apple2;

import com.uino.javalearn.apple.Apple;

public class AppleGreenColorPredicate implements ApplePerdicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
