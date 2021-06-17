package com.yandexcontest.algorithms04.E_pyramid;

// 4 E

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int number = 0;
        long height = 0;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Integer currValue = map.putIfAbsent(data[0], number);
                if (currValue == null) {
                    list.add(data[1]);
                    number++;
                } else if (list.get(currValue) < data[1])
                    list.set(currValue, data[1]);

            }

            for (int i = 0; i < list.size(); i++) {
                height += list.get(i);
            }

            writer.write("" + height);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
