package com.yandexcontest.algorithms01.D_equationroot;

// 1 D

import java.lang.Math;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double result = (Math.pow(c, 2) - b) / a;
        double difference = Math.abs(result - (int) result);

        if (a == 0 && b == Math.pow(c, 2))
            System.out.println("MANY SOLUTIONS");
        else if (c < 0 || a == 0 || difference > 0)
            System.out.println("NO SOLUTION");
        else
            System.out.println((int) result);

    }

}
