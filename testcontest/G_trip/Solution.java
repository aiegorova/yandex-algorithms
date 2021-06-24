package com.yandexcontest.testcontest.G_trip;

// 1 G

import java.io.*;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {

    public static ArrayList<Vertex> cities;
    public static long maxDistance = 0;

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());
            cities = new ArrayList<>();
            for (int i = 0; i < n; i++) {

                int[] coords = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cities.add(new Vertex(coords[0], coords[1]));

            }

            maxDistance = Integer.parseInt(reader.readLine());
            int[] data = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Vertex startCity = cities.get(data[0] - 1);
            Vertex finishCity = cities.get(data[1] - 1);

            int result = findRouteWidth(n, startCity, finishCity);
            writer.write("" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int findRouteWidth(int n, Vertex startCity, Vertex finishCity) {

        if (startCity == finishCity)
            return 0;

        HashMap<Vertex, ArrayList<Vertex>> paths = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            paths.putIfAbsent(cities.get(i), new ArrayList<>());
            for (int j = i + 1; j < n; j++) {

                paths.putIfAbsent(cities.get(j), new ArrayList<>());
                long distance = 1L * Math.abs(cities.get(i).x - cities.get(j).x) + Math.abs(cities.get(i).y - cities.get(j).y);
                if (distance <= maxDistance) {
                    if (cities.get(i) != finishCity && cities.get(j) != startCity) {
                        paths.get(cities.get(i)).add(cities.get(j));
                    }
                    if (cities.get(j) != finishCity && cities.get(i) != startCity) {
                        paths.get(cities.get(j)).add(cities.get(i));
                    }
                }

            }
        }

        HashMap<Vertex, Integer> distances = new HashMap<>();
        distances.put(startCity, 0);

        LinkedList<Vertex> queue = new LinkedList<>();
        queue.push(startCity);
        startCity.visited = true;
        boolean pathExist = false;

        while (!queue.isEmpty()) {

            Vertex city = queue.poll();
            int d = distances.get(city) + 1;

            for (Vertex neighbour : paths.get(city)) {

                if (!neighbour.visited) {

                    distances.put(neighbour, d);
                    queue.offer(neighbour);
                    neighbour.visited = true;

                    if (neighbour == finishCity) {
                        pathExist = true;
                        break;
                    }

                }

            }
            if (pathExist)
                break;

        }

        if (pathExist)
            return distances.get(finishCity);
        else
            return -1;

    }

}

class Vertex {

    public int x;
    public int y;
    public boolean visited;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
        visited = false;
    }

}