package com.yandexcontest.algorithms02.J_triangleMaxim;

// 2 J

import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String typeCloser = "closer";

            int amount = Integer.parseInt(reader.readLine());
            double lowerBound = 30.0;
            double upperBound = 4000.0;
            double prevValue = Double.parseDouble(reader.readLine());

            for (int i = 1; i < amount; i++) {

                String[] data = reader.readLine().split(" ");
                double currValue = Double.parseDouble(data[0]);

                if (data[1].equals(typeCloser)) {

                    if (currValue <= prevValue)
                        upperBound = Math.min(upperBound, currValue + (prevValue - currValue) / 2);
                    else
                        lowerBound = Math.max(lowerBound, currValue - (currValue - prevValue) / 2);

                } else {

                    if (currValue <= prevValue)
                        lowerBound = Math.max(lowerBound, prevValue - (prevValue - currValue) / 2);
                    else
                        upperBound = Math.min(upperBound, prevValue + (currValue - prevValue) / 2);

                }

                prevValue = currValue;

            }

            writer.write(String.format("%6f %6f", lowerBound, upperBound));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
После разбора:
решено также
 */