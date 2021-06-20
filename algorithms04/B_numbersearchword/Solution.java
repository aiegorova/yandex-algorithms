package com.yandexcontest.algorithms04.B_numbersearchword;

// 4 B

import java.io.*;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            while (reader.ready()) {
                String[] data = reader.readLine().split(" ");
                for (int i = 0; i < data.length; i++) {
                    if (data[i].isEmpty())
                        continue;
                    map.putIfAbsent(data[i], 0);
                    int currValue = map.get(data[i]);
                    writer.write("" + currValue + " ");
                    map.replace(data[i], currValue + 1);
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
