package com.yandexcontest.algorithms04.F_sales;

// 4 F

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            HashMap<String, HashMap<String, Long>> map = new HashMap<>();

            while (reader.ready()) {

                String[] data = reader.readLine().split(" ");

                if (!map.containsKey(data[0])) {
                    HashMap<String, Long> currData = new HashMap<>();
                    currData.put(data[1], Long.parseLong(data[2]));
                    map.put(data[0], currData);
                }
                else {
                    HashMap<String, Long> currCustomer = map.get(data[0]);
                    if (!currCustomer.containsKey(data[1]))
                        currCustomer.put(data[1], Long.parseLong(data[2]));
                    else
                        currCustomer.replace(data[1], currCustomer.get(data[1]) + Long.parseLong(data[2]));
                }

            }

            List<String> customers = map.keySet().stream().sorted().collect(Collectors.toList());
            for (int i = 0; i < customers.size(); i++) {
                writer.write(customers.get(i) + ":\n");
                List<String> goods = map.get(customers.get(i)).keySet().stream().sorted().collect(Collectors.toList());
                for (int j = 0; j < goods.size(); j++) {
                    writer.write(goods.get(j) + " " + map.get(customers.get(i)).get(goods.get(j)) + "\n");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
