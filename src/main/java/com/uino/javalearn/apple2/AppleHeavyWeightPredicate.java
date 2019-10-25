package com.uino.javalearn.apple2;

import com.uino.javalearn.apple.Apple;

public class AppleHeavyWeightPredicate implements  ApplePerdicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight()>150;
    }
}
