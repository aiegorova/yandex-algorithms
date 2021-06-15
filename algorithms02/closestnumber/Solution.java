package com.yandexcontest.algorithms02.closestnumber;

// 2 C

import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int amount = Integer.parseInt(reader.readLine());
            String[] data = reader.readLine().split(" ");
            int number = Integer.parseInt(reader.readLine());

            int[] ints = new int[amount];
            for (int i = 0; i < amount; i++) {
                ints[i] = Integer.parseInt(data[i]);
            }

            writer.write("" + findClosestNumber(ints, number));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int findClosestNumber(int[] ints, int number) {

        int difference = Math.abs(ints[0] - number);
        int result = ints[0];

        if (difference == 0)
            return result;

        for (int i = 1; i < ints.length; i++) {
            if (Math.abs(ints[i] - number) < difference) {
                difference = Math.abs(ints[i] - number);
                result = ints[i];
            }
            if (difference == 0)
                return result;
        }

        return result;

    }
}

/*
Напишите программу, которая находит в массиве элемент, самый близкий по величине к  данному числу.

Формат ввода
В первой строке задается одно натуральное число N, не превосходящее 1000 – размер массива. Во второй строке содержатся N чисел – элементы массива (целые числа, не превосходящие по модулю 1000). В третьей строке вводится одно целое число x, не превосходящее по модулю 1000.

Формат вывода
Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.

Пример 1
Ввод	Вывод
5
1 2 3 4 5
6
5
Пример 2
Ввод	Вывод
5
5 4 3 2 1
3
 */