package com.yandexcontest.algorithms02.A_increaselist;

// 2 A

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        if (data.length == 0)
            System.out.println("NO");
        else {

            String result = "YES";
            int prev = Integer.parseInt(data[0]);
            for (int i = 1; i < data.length; i++) {
                int curr = Integer.parseInt(data[i]);
                if (prev >= curr) {
                    result = "NO";
                    break;
                }
                prev = curr;
            }
            System.out.println(result);
        }

    }
}
