package com.yandexalgorithms.algorithms03.A_amountdistinct;

// 3 A

import java.io.*;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            HashSet<Object> set = new HashSet<>();

            int[] ints = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < ints.length; i++) {
                set.add(ints[i]);
            }

            writer.write("" + set.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
