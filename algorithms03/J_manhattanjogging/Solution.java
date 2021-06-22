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

            ArrayList<Point> points = new ArrayList<>();
            points.add(new Point(0, 0));

            for (int i = 0; i < n; i++) {

                int[] coords = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

                int size = points.size();
                for (int l = 0; l < size; l++) {
                    for (int j = 0; j < t; j++) {
                        for (int k = 1; k <= t - j; k++) {

                            if (Math.abs(coords[0] - (points.get(l).x + j)) + Math.abs(coords[1] - (points.get(l).y + k)) <= d) {
                                Point point1 = new Point(points.get(l).x + j, points.get(l).y + k);
                                if (!points.contains(point1))
                                    points.add(point1);
                            }
                            if (Math.abs(coords[0] - (points.get(l).x + k)) + Math.abs(coords[1] - (points.get(l).y - j)) <= d) {
                                Point point2 = new Point(points.get(l).x + k, points.get(l).y - j);
                                if (!points.contains(point2))
                                    points.add(point2);
                            }
                            if (Math.abs(coords[0] - (points.get(l).x - j)) + Math.abs(coords[1] - (points.get(l).y - k)) <= d) {
                                Point point3 = new Point(points.get(l).x - j, points.get(l).y - k);
                                if (!points.contains(point3))
                                    points.add(point3);
                            }
                            if (Math.abs(coords[0] - (points.get(l).x - k)) + Math.abs(coords[1] - (points.get(l).y + j)) <= d) {
                                Point point4 = new Point(points.get(l).x - k, points.get(l).y + j);
                                if (!points.contains(point4))
                                    points.add(point4);
                            }

                        }
                    }

                    if (Math.abs(coords[0] - points.get(l).x) + Math.abs(coords[1] - points.get(l).y) > d) {
                        points.remove(l);
                        l--;
                        size--;
                    }

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
