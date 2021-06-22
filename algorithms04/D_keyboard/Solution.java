package com.yandexcontest.algorithms04.D_keyboard;

// 4 D

import java.io.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            int[] possibleAmounts = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int k = Integer.parseInt(reader.readLine());
            int[] pushs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < k; i++) {
                possibleAmounts[pushs[i] - 1]--;
            }

            for (int i = 0; i < n; i++) {
                writer.write((possibleAmounts[i] < 0 ? "YES" : "NO") + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
