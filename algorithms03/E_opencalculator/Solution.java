package com.yandexalgorithms.algorithms03.E_opencalculator;

// 3 E

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

            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = numbers[0];
            int y = numbers[1];
            int z = numbers[2];
            int n = Integer.parseInt(reader.readLine());

            int m = 0;
            do {
                m = n % 10;
                if (m != x && m != y && m!= z)
                    set.add(m);
                n = n / 10;
            } while (n != 0);

            writer.write("" + set.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
