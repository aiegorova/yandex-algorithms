package com.yandexcontest.algorithms01.equationsystem;

// 1 J

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();

        if (a == 0.0 && b == 0.0 && c == 0.0 && d == 0.0 && e == 0.0 && f == 0.0) // 0 = 0; 0 = 0
            System.out.println(5);

        else if (b == 0.0 && d == 0.0 && c == 0.0 && f == 0.0 && a != 0.0) // ax = e; 0 = 0
            System.out.printf("%d %f", 3, e/a);

        else if (b == 0.0 && d == 0.0 && c != 0 && (a == 0.0 && e == 0.0 || e/a == f/c)) // 0 = 0; cx = f && ax = e; cx = f
            System.out.printf("%d %f", 3, f/c);

        else if (a == 0.0 && c == 0.0 && b == 0.0 && e == 0.0 && d != 0.0) // 0 = 0; dy = f
            System.out.printf("%d %f", 4, f/d);

        else if (a == 0.0 && c == 0.0 && b != 0.0 && (d == 0.0 && f == 0.0 || e/b == f/d)) // by = e; 0 = 0 && by = e; dy = f
            System.out.printf("%d %f", 4, e/b);

        else if (a == 0.0 && b == 0.0 && e == 0.0 && c != 0 && d != 0.0) // 0 = 0; cx + dy = f
            System.out.printf("%d %f %f", 1, -c/d, f/d);

        else if (c == 0.0 && d == 0.0 && f == 0.0 && a != 0 && b != 0.0) // ax + by = e; 0 = 0
            System.out.printf("%d %f %f", 1, -a/b, e/b);

        else if (b != 0 && d != 0 && a/b == c/d && f/d == e/b) // ax + by = e; cx + dy = f
            System.out.printf("%d %f %f", 1, -c/d, f/d);

        else if ((a * d - b * c) != 0.0 && d != 0.0) {
            double x = (e * d - b * f) / (a * d - b * c);
            System.out.printf("%d %f %f", 2, x, (f - c * x) / d);

        } else if ((c * b - a * d) != 0.0 && b != 0) {
            double x = (f * b - d * e) / (c * b - a * d);
            System.out.printf("%d %f %f", 2, x, (e - a * x) / b);

        } else
            System.out.println(0);

    }
}

/*
Даны числа a, b, c, d, e, f. Решите систему линейных уравнений



Формат ввода
Вводятся 6 вещественных чисел - коэффициенты уравнений.

Формат вывода
Вывод программы зависит от вида решения этой системы. Если система не имеет решений, то программа должна вывести единственное число 0. Если система имеет бесконечно много решений, каждое из которых имеет вид y=kx+b, то программа должна вывести число 1, а затем значения k и b. Если система имеет единственное решение (x0,y0), то программа должна вывести число 2, а затем значения x0 и y0. Если система имеет бесконечно много решений вида x=x0, y — любое, то программа должна вывести число 3, а затем значение x0. Если система имеет бесконечно много решений вида y=y0, x — любое, то программа должна вывести число 4, а затем значение y0. Если любая пара чисел (x,y) является решением, то программа должна вывести число 5.

Числа x0 и y0 будут проверяться с точностью до пяти знаков после точки.

Пример 1
Ввод	Вывод
1
0
0
1
3
3
2 3 3
Пример 2
Ввод	Вывод
1
1
2
2
1
2
1 -1 1
Пример 3
Ввод	Вывод
0
2
0
4
1
2
4 0.5

Ломалось на:
0
-1
-3
0
5
3

и еще:
0
0
1
2
0
3

и еще:
0
0
0
0
1
2

 */