package com.yandexalgorithms.algorithms02.G_biggestmultiplication;

// 2 G

import java.io.*;
import java.lang.Math;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] ints = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] result = findTheBiggest(ints);

            writer.write("" + result[0] + " " + result[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int[] findTheBiggest(int[] ints) {

        int max1 = Math.max(ints[0], ints[1]);
        int max2 = Math.min(ints[0], ints[1]);

        int min1 = max2;
        int min2 = max1;

        for (int i = 2; i < ints.length; i++) {
            if (ints[i] > max1) {
                max2 = max1;
                max1 = ints[i];
            } else if (ints[i] > max2)
                max2 = ints[i];
            else if (ints[i] < min1) {
                min2 = min1;
                min1 = ints[i];
            } else if (ints[i] < min2)
                min2 = ints[i];
        }

        if (min2 >= 0)
            return new int[] {max2, max1};
	    else {
	        long difference = 1L * (max1 + min1) * -min2 + 1L * (max2 + min2) * -min1 + 1L *(max1 + min1) * (max2 + min2);
	        if (difference > 0)
                return new int[] {max2, max1};
	        else
                return new int[] {min1, min2};
	    }

    }
}

/*
Ломалось на больших числах:
-992983 -991580 995889 994528

и еще:
-999232 -998633 997847 997256
 */