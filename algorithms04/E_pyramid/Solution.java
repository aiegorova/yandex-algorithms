package com.yandexcontest.algorithms04.E_pyramid;

// 4 E

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        long height = 0;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            ArrayList<Integer> widths = new ArrayList<>();
            ArrayList<Integer> heights = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int index = widths.indexOf(data[0]);
                if (index == -1) {
                    widths.add(data[0]);
                    heights.add(data[1]);
                } else if (heights.get(index) < data[1]) {
                    heights.set(index, data[1]);
                }

            }

            for (int i = 0; i < heights.size(); i++) {
                height += heights.get(i);
            }

            writer.write("" + height);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
