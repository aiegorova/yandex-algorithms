package com.yandexcontest.algorithms01.B_triangle;

// 1 B

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        if (x + y >= z && y + z >= x && x + z >= y)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}
