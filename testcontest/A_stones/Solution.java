package com.yandexcontest.testcontest.A_stones;

// 1 A

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String J = scanner.nextLine();
        String S = scanner.nextLine();

        int count = 0;
        for (char ch : S.toCharArray()) {
            if (J.indexOf(ch) >= 0)
                count++;
        }

        System.out.println(count);

    }
}
