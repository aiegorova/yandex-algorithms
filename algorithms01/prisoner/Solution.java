package com.yandexcontest.algorithms01.prisoner;

// 1 I

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lengthBrick = scanner.nextInt();
        int widthBrick = scanner.nextInt();
        int heightBrick = scanner.nextInt();
        int heightHole = scanner.nextInt();
        int widthHole = scanner.nextInt();

        boolean result = (heightHole >= heightBrick)
                && (widthHole >= widthBrick || widthHole >= lengthBrick)
                || (heightHole >= widthBrick)
                && (widthHole >= heightBrick || widthHole >= lengthBrick)
                || (heightHole >= lengthBrick)
                && (widthHole >= widthBrick || widthHole >= heightBrick);

        System.out.println(result == true ? "YES" : "NO");

    }
}

/*
За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E. Замок Иф сложен из кирпичей, размером A × B × C. Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие, если стороны кирпича должны быть параллельны сторонам отверстия.

Формат ввода
Программа получает на вход числа A, B, C, D, E.

Формат вывода
Программа должна вывести слово YES или NO.

Пример 1
Ввод	Вывод
1
1
1
1
1
YES
Пример 2
Ввод	Вывод
2
2
2
1
1
NO

После разбора:
Предлагают найти у кирпича 2 самые маленькие стороны и сравнивать их со сторонами кирпича
Причем стены кирпича тоже предлагается упорядочить
Т.е. самую маленькую сторону кирпича сравнивать с меньшей стороной дырки
Вторую маленькую сторону кирпича сравнивать с большей стороной дырки
Сортировку 3 чисел предлагает делать пузырьком
 */