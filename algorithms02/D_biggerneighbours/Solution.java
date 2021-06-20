package com.yandexcontest.algorithms02.D_biggerneighbours;

// 2 D

import java.util.Scanner;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(findAmount(ints));

    }

    public static int findAmount(int[] ints) {

        int result = 0;

        for (int i = 1; i < ints.length - 1; i++) {

            if (ints[i] > ints[i - 1] && ints[i] > ints[i + 1]) {
                result++;
                i++;
            }

        }

        return result;

    }
}
