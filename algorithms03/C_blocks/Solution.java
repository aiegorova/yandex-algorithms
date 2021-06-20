package com.yandexalgorithms.algorithms03.C_blocks;

// 3 C

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = data[0];
            int m = data[1];

            Set<Integer> colors1 = new HashSet<Integer>();
            int amount = 0;
            for (int i = 0; i < n; i++) {
                colors1.add(Integer.parseInt(reader.readLine()));
            }

            Set<Integer> colors2 = new HashSet<Integer>();
            Set<Integer> commonColors = new HashSet<>();
            for (int i = 0; i < m; i++) {
                int currColor = Integer.parseInt(reader.readLine());
                if (colors1.contains(currColor)) {
                    colors1.remove(currColor);
                    commonColors.add(currColor);
                    amount++;
                } else
                    colors2.add(currColor);
            }

            Object[] commonColorsArr = commonColors.stream().sorted().toArray();
            writer.write("" + amount + "\n");
            for (int i = 0; i < commonColorsArr.length; i++) {
                writer.write("" + commonColorsArr[i] + " ");
            }

            Object[] colors1Arr = colors1.stream().sorted().toArray();
            writer.write("\n" + (n - amount) + "\n");
            for (int i = 0; i < colors1Arr.length; i++) {
                writer.write("" + colors1Arr[i] + " ");
            }

            Object[] colors2Arr = colors2.stream().sorted().toArray();
            writer.write("\n" + (m - amount) + "\n");
            for (int i = 0; i < colors2Arr.length; i++) {
                writer.write("" + colors2Arr[i] + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
