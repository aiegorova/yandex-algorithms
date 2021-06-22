package com.yandexcontest.algorithms03.G_turtles;

// 3 G

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {

        HashSet<Integer> set = new HashSet<>();

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int amountInFront = data[0];
                int amountBehind = data[1];

                if (amountInFront + amountBehind == n - 1 && amountInFront >= 0 && amountBehind >= 0)
                    set.add(amountInFront);

            }

            writer.write("" + set.size());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
Ломалось на:
отрицательных числах

После разбора:
решено также
 */