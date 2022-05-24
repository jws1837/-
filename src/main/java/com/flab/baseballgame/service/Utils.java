package com.flab.baseballgame.service;

import java.util.Arrays;
import java.util.Random;

public class Utils {
    public static void main(String[] args) {
        System.out.println(getThreeRandumNumber());
    }
    public static int getThreeRandumNumber() {
        int temp[] = new int[3];
        temp[0] = new Random().nextInt(9);
        for (int i = 1; i < 3; i++) {
            temp[i] = new Random().nextInt(9);
            if (temp[i] == temp[i + 1]) {
                new Random().nextInt(9);
            }
        }
        Arrays.toString(temp).replaceAll("[^0-9]","");
       int number =  Integer.parseInt(Arrays.toString(temp));

        return number;
    }
}
