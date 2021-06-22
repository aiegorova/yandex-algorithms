package com.yandexcontest.algorithms04.F_sales;

// 4 F

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            TreeMap<String, TreeMap<String, Long>> map = new TreeMap<>();

            while (reader.ready()) {

                String[] data = reader.readLine().split(" ");

                if (!map.containsKey(data[0])) {
                    TreeMap<String, Long> currData = new TreeMap<>();
                    currData.put(data[1], Long.parseLong(data[2]));
                    map.put(data[0], currData);
                }
                else {
                    TreeMap<String, Long> currCustomer = map.get(data[0]);
                    if (!currCustomer.containsKey(data[1]))
                        currCustomer.put(data[1], Long.parseLong(data[2]));
                    else
                        currCustomer.replace(data[1], currCustomer.get(data[1]) + Long.parseLong(data[2]));
                }

            }

            for (String key : map.keySet()) {
                writer.write(key + ":\n");
                for (Map.Entry<String, Long> entry : map.get(key).entrySet()) {
                    writer.write(entry.getKey() + " " + entry.getValue() + "\n");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
