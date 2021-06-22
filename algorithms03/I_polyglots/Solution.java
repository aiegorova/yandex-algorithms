package com.yandexcontest.algorithms03.I_polyglots;

// 3 I

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n - 1; i++) {

                int m = Integer.parseInt(reader.readLine());
                for (int j = 0; j < m; j++) {

                    String language = reader.readLine();
                    map.putIfAbsent(language, 0);
                    map.replace(language, map.get(language) + 1);

                    if (map.get(language) == n)
                        set.add(language);

                }

            }

            int m = Integer.parseInt(reader.readLine());
            for (int j = 0; j < m; j++) {

                String language = reader.readLine();
                map.putIfAbsent(language, 0);

                if (map.get(language) == n - 1)
                    set.add(language);

            }

            writer.write("" + set.size() + "\n");
            for (String key : set) {
                writer.write(key + "\n");
            }

            writer.write("" + map.size() + "\n");
            for (String key : map.keySet()) {
                writer.write(key + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
