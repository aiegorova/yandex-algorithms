package com.yandexcontest.algorithms02.biggestmultiplication3;

// 2 H

import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String[] data = reader.readLine().split(" ");
            int[] ints = new int[data.length];

            for (int i = 0; i < data.length; i++) {
                ints[i] = Integer.parseInt(data[i]);
            }

            int[] result = findTheBiggest3(ints);

            writer.write("" + result[0] + " " + result[1]);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int[] findTheBiggest3(int[] ints) {

        int max1 = Math.max(Math.max(ints[0], ints[1]), ints[2]);
        int max3 = Math.min(Math.min(ints[0], ints[1]), ints[2]);
        int max2 = 0;
        for (int i = 0; i < 3; i++) {
            if (ints[i] <= max1 && ints[i] >= max3)
                max2 = ints[i];
        }

        int min1 = max3;
        int min2 = max2;
        int min3 = max1;

        for (int i = 3; i < ints.length; i++) {
            if (ints[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = ints[i];
            } else if (ints[i] > max2) {
                max3 = max2;
                max2 = ints[i];
            } else if (ints[i] > max3)
                min2 = ints[i];
            else if (ints[i] < min1) {
                min3 = min2;
                min2 = min1;
                min1 = ints[i];
            } else if (ints[i] < min2) {
                min3 = min2;
                min2 = ints[i];
            } else if (ints[i] < min3)
                min3 = ints[i];

        }

        if (min2 >= 0)
            return new int[] {max3, max2, max1};
        else {
            long difference = 1L * (max1 + min1) * -min2 + 1L * (max2 + min2) * -min1 + 1L *(max1 + min1) * (max2 + min2);
            if (difference > 0)
                return new int[] {max2, max1};
            else
                return new int[] {min1, min2};
        }

    }
}

/*
В данном списке из n ≤ 105 целых чисел найдите три числа,произведение которых максимально.

Решение должно иметь сложность O(n), где n - размер списка.

Выведите три искомых числа в любом порядке.

Пример 1
Ввод	Вывод
3 5 1 7 9 0 9 -3 10
10 9 9
Пример 2
Ввод	Вывод
-5 -30000 -12
-5 -12 -30000
Пример 3
Ввод	Вывод
1 2 3
3 2 1

После разбора:
Достаточно 2 минимумов, т.к. только их умножение в случае отрицательных значений дает большое число
Предлагает делать быструю сортировку массива не полностью, а таким образом, чтобы справа
оказалось 3 самых больших, а слева 2 самых маленьких
Алгоритм поиска k-ого порядка статистики
 */