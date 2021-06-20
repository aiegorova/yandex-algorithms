package com.yandexalgorithms.algorithms04.A_synonymsdictionary;

// 4 A

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<>();

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                String[] data = reader.readLine().split(" ");
                map.put(data[0], data[1]);
            }

            String word = reader.readLine();
            if (map.containsKey(word))
                writer.write(map.get(word));
            else {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry.getValue().equals(word)) {
                        writer.write(entry.getKey());
                        break;
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
