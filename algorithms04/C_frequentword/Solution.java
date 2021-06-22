package com.yandexcontest.algorithms04.C_frequentword;

// 4 C

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            HashMap<String, Integer> map = new HashMap<>();

            int max = 1;

            while (reader.ready()) {

                String[] data = reader.readLine().split(" ");
                for (int i = 0; i < data.length; i++) {
                    if (data[i].isEmpty())
                        continue;
                    Integer currValue = map.putIfAbsent(data[i], 1);
                    if (currValue != null) {
                        map.replace(data[i], currValue + 1);
                        max = Math.max(max, currValue + 1);
                    }
                }
            }

            ArrayList<String> words = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == max)
                    words.add(entry.getKey());
            }

            Object[] arrWords = words.stream().sorted().toArray();
            if (arrWords.length > 0)
                writer.write("" + arrWords[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
