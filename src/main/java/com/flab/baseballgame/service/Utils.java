package com.flab.baseballgame.service;

import java.util.Random;

public class Utils {
    public static int getThreeRandumNumber() {
        int number = new Random().nextInt(999);
        for (; ; ) {
            if (number < 100) {
                number = new Random().nextInt(999);
            } else {
                break;
            }
        }
        return number;
    }
}
