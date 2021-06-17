package com.yandexcontest.algorithms04.E_pyramid;

// 4 E

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        long height = 0;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Integer currValue = map.putIfAbsent(data[0], data[1]);
                if (currValue != null && currValue < data[1])
                    map.replace(data[0], data[1]);

            }

            for (int value : map.values()) {
                height += value;
            }

            writer.write("" + height);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
