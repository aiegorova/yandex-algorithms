package com.yandexalgorithms.algorithms02.B_sequencetype;

// 2 B

import java.io.*;

public class Solution {

    public static void main(String[] args) {

        int finish = -2000000000;
        boolean constant = true;
        boolean ascending = true;
        boolean weaklyAscending = true;
        boolean descending = true;
        boolean weaklyDescending = true;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int prevValue = Integer.parseInt(reader.readLine());
            if (prevValue == finish) {
                writer.write("RANDOM");
                return;
            }

            int currValue = Integer.parseInt(reader.readLine());
            if (currValue == finish) {
                writer.write("RANDOM");
                return;
            }

            while (currValue != finish) {

                if (currValue != prevValue && constant)
                    constant = false;
                if (currValue <= prevValue && ascending)
                    ascending = false;
                if (currValue < prevValue && weaklyAscending)
                    weaklyAscending = false;
                if (currValue >= prevValue && descending)
                    descending = false;
                if (currValue > prevValue && weaklyDescending)
                    weaklyDescending = false;

                prevValue = currValue;
                currValue = Integer.parseInt(reader.readLine());

            }

            if (constant)
                writer.write("CONSTANT");
            else if (ascending)
                writer.write("ASCENDING");
            else if (descending)
                writer.write("DESCENDING");
            else if (weaklyAscending)
                writer.write("WEAKLY ASCENDING");
            else if (weaklyDescending)
                writer.write("WEAKLY DESCENDING");
            else
                writer.write("RANDOM");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
