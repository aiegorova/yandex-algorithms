package com.yandexcontest.algorithms03.C_blocks;

// 3 C

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = data[0];
            int m = data[1];

            Set<Integer> colors1 = new HashSet<>();
            for (int i = 0; i < n; i++) {
                colors1.add(Integer.parseInt(reader.readLine()));
            }

            Set<Integer> colors2 = new HashSet<>();
            for (int i = 0; i < m; i++) {
                colors2.add(Integer.parseInt(reader.readLine()));
            }

            Set<Integer> result = new HashSet<>();
            result.addAll(colors1);
            result.retainAll(colors2);
            result = result.stream().sorted().collect(Collectors.toSet());
            writer.write("" + result.size() + "\n");
            for (Integer value : result) {
                writer.write("" + value + " ");
            }

            result.clear();
            result.addAll(colors1);
            result.removeAll(colors2);
            result = result.stream().sorted().collect(Collectors.toSet());
            writer.write("\n" + result.size() + "\n");
            for (Integer value :  result) {
                writer.write("" + value + " ");
            }

            result.clear();
            result.addAll(colors2);
            result.removeAll(colors1);
            result = result.stream().sorted().collect(Collectors.toSet());
            writer.write("\n" + result.size() + "\n");
            for (Integer value : result) {
                writer.write("" + value + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
