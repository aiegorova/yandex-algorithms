package com.yandexcontest.algorithms01.triangle;

// 1 B

import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        if (x + y >= z && y + z >= x && x + z >= y)
            System.out.println("YES");
        else
            System.out.println("NO");

    }
}

/*
Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами. Если это возможно, выведите строку YES, иначе выведите строку NO.

Треугольник — это три точки, не лежащие на одной прямой.

Формат ввода
Вводятся три натуральных числа.

Формат вывода
Выведите ответ на задачу.

Пример 1
Ввод	Вывод
3
4
5

YES
Пример 2
Ввод	Вывод
3
5
4


YES
Пример 3
Ввод	Вывод
4
5
3
YES
 */