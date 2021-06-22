package com.yandexcontest.algorithms01.H_underground;

// 1 H

import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int intervalFirst = scanner.nextInt();
        int intervalSecond = scanner.nextInt();
        int amountFirst = scanner.nextInt();
        int amountSecond = scanner.nextInt();

        int minFirst = intervalFirst * (amountFirst - 1) + amountFirst;
        int maxFirst = intervalFirst * (amountFirst + 1) + amountFirst;
        int minSecond = intervalSecond * (amountSecond - 1) + amountSecond;
        int maxSecond = intervalSecond * (amountSecond + 1) + amountSecond;

        if (minFirst > maxSecond || minSecond > maxFirst)
            System.out.println(-1);
        else
            System.out.printf("%d %d", Math.max(minFirst, minSecond), Math.min(maxFirst, maxSecond));

    }
}

/*
После разбора:
решено также
можно только сначала посчитать минимум и максимум, а потом сравнивать их
 */