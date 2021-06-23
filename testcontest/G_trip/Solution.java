package com.yandexcontest.testcontest.G_trip;

// 1 G

import java.io.*;
import java.lang.Math;
import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static City[] cities;
    public static Stack<City> stack = new Stack<>();
    public static int maxDistance = 0;
    public static City finishCity;
    public static int minAmount = -1;

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader buffer = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(buffer.readLine());

            cities = new City[n];
            for (int i = 0; i < n; i++) {

                int[] data = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                cities[i] = new City(data[0], data[1]);

            }

            maxDistance = Integer.parseInt(buffer.readLine());
            int[] data = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            City startCity = cities[data[0] - 1];
            finishCity = cities[data[1] - 1];

            stack.push(startCity);
            checkRoute();

            writer.write("" + minAmount);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void checkRoute() {

        City currCity = stack.peek();

        if (currCity == finishCity) {
            if (minAmount == -1)
                minAmount = stack.size() - 1;
            else
                minAmount = Math.min(minAmount, stack.size() - 1);
            return;
        }

        for (City city : cities) {

            if (stack.contains(city))
                continue;
            if (Math.abs(currCity.x - city.x) + Math.abs(currCity.y - city.y) > maxDistance)
                continue;
            stack.push(city);
            checkRoute();
            stack.pop();

        }


    }

}

class City {

    public int x;
    public int y;

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
