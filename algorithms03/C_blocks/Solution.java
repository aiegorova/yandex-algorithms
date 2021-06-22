package com.yandexcontest.algorithms03.C_blocks;

// 3 C

import java.io.*;
import java.util.Arrays;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = data[0];
            int m = data[1];

            ArrayList<Integer> colors1 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                colors1.add(Integer.parseInt(reader.readLine()));
            }
            colors1.sort((x1, x2) -> x1 - x2);

            ArrayList<Integer> colors2 = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                colors2.add(Integer.parseInt(reader.readLine()));
            }
            colors2.sort((x1, x2) -> x1 - x2);

            ArrayList<Integer> commonColors = new ArrayList<>();
            int cnt1 = 0;
            int cnt2 = 0;
            while (cnt1 < colors1.size() && cnt2 < colors2.size()) {
                if (colors1.get(cnt1) == colors2.get(cnt2)) {
                    commonColors.add(colors1.get(cnt1));
                    colors1.remove(cnt1);
                    colors2.remove(cnt2);
                } else if (colors1.get(cnt1) > colors2.get(cnt2))
                    cnt2++;
                else if (colors1.get(cnt1) < colors2.get(cnt2))
                    cnt1++;
            }

            writer.write("" + commonColors.size() + "\n");
            for (int i = 0; i < commonColors.size(); i++) {
                writer.write("" + commonColors.get(i) + " ");
            }

            writer.write("\n" + colors1.size() + "\n");
            for (int i = 0; i < colors1.size(); i++) {
                writer.write("" + colors1.get(i) + " ");
            }

            writer.write("\n" + colors2.size() + "\n");
            for (int i = 0; i < colors2.size(); i++) {
                writer.write("" + colors2.get(i) + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
