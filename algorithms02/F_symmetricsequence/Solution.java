package com.yandexcontest.algorithms02.F_symmetricsequence;

// 2 F

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            List<Integer> data = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int result = findSymmetricValues(data, n);

            writer.write("" + result);
            if (result > 0)
                writer.write("\n");
            for (int i = 0; i < result; i++) {
                writer.write("" + data.get(result - i - 1) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int findSymmetricValues(List<Integer> list, int n) {

        int amount = 0;

        for (int i = 0; i < n - 1; i++) {

            if (i >= n/2 && amount == 0)
                break;

            if (list.get(i) != list.get(n - 1 - i + amount))
                amount = i + 1;

        }

        return amount;

    }
}
