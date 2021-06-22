package com.yandexcontest.algorithms03.J_manhattanjogging;

// 3 J

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int t = data[0];
            int d = data[1];
            int n = data[2];

            int upperLeft = 0;
            int lowerLeft = 0;

            int upperRight = 0;
            int lowerRight = 0;

            int lowerRightBorder = 0;
            int upperRightBorder = 0;

            int lowerLeftBorder = 0;
            int upperLeftBorder = 0;

            for (int i = 0; i < n; i++) {

                upperLeft = upperLeftBorder + t;
                upperRight = upperRightBorder + t;
                lowerLeft = lowerLeftBorder - t;
                lowerRight = lowerRightBorder - t;

                int[] coords = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                lowerRightBorder = Math.max(lowerRight, coords[1] + coords[0] - d);
                upperRightBorder = Math.min(upperRight, coords[1] + coords[0] + d);

                lowerLeftBorder = Math.max(lowerLeft, coords[1] - coords[0] - d);
                upperLeftBorder = Math.min(upperLeft, coords[1] - coords[0] + d);

            }

            ArrayList<Point> points = new ArrayList<>();
            for (int i = lowerRightBorder; i <= upperRightBorder; i++) {
                for (int j = lowerLeftBorder; j <= upperLeftBorder; j++) {
                    if ((i - j) % 2 == 0)
                        points.add(new Point((i - j)/2, (i - j)/2 + j));
                }
            }

            writer.write("" + points.size() + "\n");
            for (int i = 0; i < points.size(); i++) {
                writer.write("" + points.get(i).x + " " + points.get(i).y + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
После разбора:
решено также
 */