package com.yandexcontest.algorithms02.E_cowwaste;

// 2 E

import java.io.*;
import java.lang.Math;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            int[] results = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            writer.write("" + findPlace(results, n));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int findPlace(int[] results, int n) {

        int max = results[0];
        int currValue = 0, place = 0;

        for (int i = 1; i < n - 1; i++) {

            if (results[i] > max) {
                max = results[i];
                currValue = 0;
            } else if (results[i] % 10 == 5 && results[i + 1] < results[i])
                currValue = Math.max(currValue, results[i]);

        }

        if (results[n-1] > max) {
            currValue = 0;
        }

        if (currValue == 0)
            return place;

        place++;
        for (int i = 0; i < n; i++) {
            if (results[i] > currValue)
                place++;
        }
        return place;

    }
}
