package com.flab.baseballgame.domain;

import java.util.Random;

public class Utils {

    public static int getThreeRandomNumber() {
        return internalNextInt(100,999);
    }

    public static String getNotDuplicationRandomNumber() {
        int number;
        for (; ; ) {
            number = internalNextInt(111, 999);
            String temp = Integer.toString(number);
            if (temp.charAt(0) == temp.charAt(1) || temp.charAt(1) == temp.charAt(2) || temp.charAt(0) == temp.charAt(2)) {
            } else {
                break;
            }
        }
        return String.valueOf(number);
    }

    private static int internalNextInt(int origin, int bound) {
        if (origin < bound) {
            int n = bound - origin;
            if (n > 0) {
                return new Random().nextInt(n) + origin;
            } else {  // range not representable as int
                int r;
                do {
                    r = new Random().nextInt();
                } while (r < origin || r >= bound);
                return r;
            }
        } else {
            return new Random().nextInt();
        }
    }

}
