package com.yandexcontest.algorithms03.B_setintersection;

// 3 B

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            Set<Integer> ints1 = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toSet());
            Set<Integer> ints2 = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toSet());

            ArrayList<Integer> list = new ArrayList<>();
            for (Integer number : ints2) {
                if (ints1.contains(number))
                    list.add(number);
            }

            list.sort((x1, x2) -> x1 - x2);

            for (int i = 0; i < list.size(); i++) {
                writer.write(list.get(i) + " ");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
