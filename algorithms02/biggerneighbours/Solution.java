package com.yandexcontest.algorithms02.biggerneighbours;

// 2 D

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int[] ints = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            ints[i] = Integer.parseInt(data[i]);
        }

        System.out.println(findAmount(ints));

    }

    public static int findAmount(int[] ints) {

        int result = 0;

        for (int i = 1; i < ints.length - 1; i++) {

            if (ints[i] > ints[i - 1] && ints[i] > ints[i + 1]) {
                result++;
                i++;
            }

        }

        return result;

    }
}

/*
Дан список чисел. Определите, сколько в этом списке элементов, которые больше двух своих соседей и выведите количество таких элементов.

Формат ввода
Вводится список чисел. Все числа списка находятся на одной строке.

Формат вывода
Выведите ответ на задачу.

Пример 1
Ввод	Вывод
1 2 3 4 5
0
Пример 2
Ввод	Вывод
5 4 3 2 1
0
Пример 3
Ввод	Вывод
1 5 1 5 1
2
 */