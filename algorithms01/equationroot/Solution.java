package com.yandexcontest.algorithms01.equationroot;

// 1 D

import java.lang.Math;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        double result = (Math.pow(c, 2) - b) / a;
        double difference = Math.abs(result - (int) result);

        if (a == 0 && b == Math.pow(c, 2))
            System.out.println("MANY SOLUTIONS");
        else if (c < 0 || a == 0 || difference > 0)
            System.out.println("NO SOLUTION");
        else
            System.out.println((int) result);

    }

}

/*
Решите в целых числах уравнение:

,

a, b, c – данные целые числа: найдите все решения или сообщите, что решений в целых числах нет.

Формат ввода
Вводятся три числа a, b и c по одному в строке.

Формат вывода
Программа должна вывести все решения уравнения в порядке возрастания, либо NO SOLUTION (заглавными буквами), если решений нет. Если решений бесконечно много, вывести MANY SOLUTIONS.

Пример 1
Ввод	Вывод
1
0
0
0
Пример 2
Ввод	Вывод
1
2
3
7
Пример 3
Ввод	Вывод
1
2
-3
NO SOLUTION
 */