package com.yandexcontest.algorithms03.F_aliengenome;

// 3 F

import java.io.*;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        int amount = 0;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String genome1 = reader.readLine();
            String genome2 = reader.readLine();

            for (int i = 0; i < genome2.length() - 1; i++) {
                set.add(genome2.substring(i, i + 2));
            }

            for (int i = 0; i < genome1.length() - 1; i++) {
                if (set.contains(genome1.substring(i, i + 2)))
                    amount++;
            }

            writer.write("" + amount);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
