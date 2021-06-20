package com.yandexalgorithms.algorithms03.D_wordstext;

// 3 D

import java.io.*;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        String emptyString = "";

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            while (reader.ready()) {

                String[] data = reader.readLine().split(" ");
                for (int i = 0; i < data.length; i++) {
                    if (data[i].equals(emptyString))
                        continue;
                    set.add(data[i]);
                }

            }

            writer.write("" + set.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
