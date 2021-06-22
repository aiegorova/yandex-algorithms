package com.yandexcontest.algorithms03.H_angrypigs;

// 3 H

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                set.add(data[0]);

            }

            writer.write("" + set.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
