package com.yandexcontest.testcontest.B_binary;

// 1 B

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int count = 0, max = 0;

        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            if (number == 1)
                count++;
            else
                count = 0;
            max = count > max ? count : max;
        }

        System.out.println(max);

    }

}