package com.yandexcontest.algorithms02.C_closestnumber;

// 2 C

import java.io.*;
import java.lang.Math;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int amount = Integer.parseInt(reader.readLine());
            int[] ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int number = Integer.parseInt(reader.readLine());

            writer.write("" + findClosestNumber(ints, number));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int findClosestNumber(int[] ints, int number) {

        int difference = Math.abs(ints[0] - number);
        int result = ints[0];

        if (difference == 0)
            return result;

        for (int i = 1; i < ints.length; i++) {
            if (Math.abs(ints[i] - number) < difference) {
                difference = Math.abs(ints[i] - number);
                result = ints[i];
            }
            if (difference == 0)
                return result;
        }

        return result;

    }
}
