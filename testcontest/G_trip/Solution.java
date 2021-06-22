package com.yandexcontest.testcontest.G_trip;

// 1 G

import java.io.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static int maxDistance = 0;
    public static City finishCity;
    public static ArrayList<Integer> routes = new ArrayList<>();

    public static void main(String[] args) {

        fillCities();

    }

    public static void fillCities() {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader buffer = new BufferedReader(fileReader)) {

            int n = Integer.parseInt(buffer.readLine());

            ArrayList<City> cities = new ArrayList<>();

            for (int i = 1; i <= n; i++) {

                String[] strings = buffer.readLine().split(" ");
                cities.add(new City(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), i));

            }

            maxDistance = Integer.parseInt(buffer.readLine());
            String[] strings = buffer.readLine().split(" ");
            City startCity = cities.get(Integer.parseInt(strings[0]) - 1);
            finishCity = cities.get(Integer.parseInt(strings[1]) - 1);

            ArrayList<Section> sections = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {

                City start = cities.get(i);

                for (int j = i + 1; j < n; j++) {

                    City finish = cities.get(j);
                    int distance = Math.abs(start.x - finish.x) + Math.abs(start.y - finish.y);

                    if (distance > maxDistance)
                        continue;

                    sections.add(new Section(start, finish, distance));
                    sections.add(new Section(finish, start, distance));

                }

            }

            createRoute(sections, startCity, 0);

            if (routes.size() == 0)
                System.out.println(-1);
            else
                System.out.println(routes.stream().min((x1, x2) -> x1 - x2).get());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createRoute(List<Section> sections, City startCity, int number) {

        if (routes.contains(1))
            return;
        if (startCity == finishCity) {
            routes.add(number);
            return;
        }

        List<Section> nextSections = sections.stream().filter(section -> section.cityStart == startCity).collect(Collectors.toList());
        for (Section section : nextSections) {
            createRoute(sections.stream().filter(sect -> sect.cityStart != startCity && sect.cityFinish != startCity).collect(Collectors.toList()), section.cityFinish, number + 1);
        }
    }
}

class City {

    public int x;
    public int y;
    public int index;

    public City(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }

}

class Section {

    public City cityStart;
    public City cityFinish;

    public int distance;

    public Section(City cityStart, City cityFinish, int distance) {
        this.cityStart = cityStart;
        this.cityFinish = cityFinish;
        this.distance = distance;
    }

}
