package com.yandexcontest.algorithms01.ambulance;

// 1 E

import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int currFlat = Integer.parseInt(data[0]);
        int floorsAmount = Integer.parseInt(data[1]);
        int prevFlat = Integer.parseInt(data[2]);
        int prevSection = Integer.parseInt(data[3]);
        int prevFloor = Integer.parseInt(data[4]);

        int currSection = 0, currFloor = 0;

        if (prevSection == 1 && prevFloor == 1) {

            if (currFlat <= prevFlat) {
                currSection = 1;
                currFloor = 1;
            } else if (floorsAmount == 1)
                currFloor = 1;
            else if (currFlat <= prevFlat * floorsAmount)
                currSection = 1;

        } else {

            int upperBound = (int) Math.floor(1.0 * (prevFlat - 1) / ((prevSection - 1) * floorsAmount + (prevFloor - 1))); // x <=
            int lowerBound = (int) Math.ceil(1.0 * prevFlat / ((prevSection - 1) * floorsAmount + prevFloor)); // x >=

            if (upperBound < lowerBound || upperBound <= 0 || prevFloor > floorsAmount) {
                currSection = -1;
                currFloor = -1;
            } else {

                int section1 = (int) Math.ceil(1.0 * currFlat / lowerBound / floorsAmount);
                int section2 = (int) Math.ceil(1.0 * currFlat / upperBound / floorsAmount);

                currSection = section1 == section2 ? section1 : 0;

                int floor1 = (int) Math.ceil(1.0 * (currFlat - (section1 - 1) * lowerBound * floorsAmount) / lowerBound);
                int floor2 = (int) Math.ceil(1.0 * (currFlat - (section2 - 1) * upperBound * floorsAmount) / upperBound);

                currFloor = floor1 == floor2 ? floor1 : 0;

            }

        }

        System.out.printf("%d %d", currSection, currFloor);

    }

}

/*
Бригада скорой помощи выехала по вызову в один из отделенных районов. К сожалению, когда диспетчер получил вызов, он успел записать только адрес дома и номер квартиры K1, а затем связь прервалась. Однако он вспомнил, что по этому же адресу дома некоторое время назад скорая помощь выезжала в квартиру K2, которая расположена в подъезда P2 на этаже N2. Известно, что в доме M этажей и количество квартир на каждой лестничной площадке одинаково. Напишите программу, которая вычилсяет номер подъезда P1 и номер этажа N1 квартиры K1.

Формат ввода
Во входном файле записаны пять положительных целых чисел K1, M, K2, P2, N2. Все числа не превосходят 106.

Формат вывода
Выведите два числа P1 и N1. Если входные данные не позволяют однозначно определить P1 или N1, вместо соответствующего числа напечатайте 0. Если входные данные противоречивы, напечатайте два числа –1 (минус один).

Пример 1
Ввод	Вывод
89 20 41 1 11
2 3
Пример 2
Ввод	Вывод
11 1 1 1 1
0 1
Пример 3
Ввод	Вывод
3 2 2 2 1
-1 -1

Ломалось на:
10 3 50 1 50
 */