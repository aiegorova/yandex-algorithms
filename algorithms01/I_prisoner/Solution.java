package com.yandexcontest.algorithms01.I_prisoner;

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
После разбора:
Предлагают найти у кирпича 2 самые маленькие стороны и сравнивать их со сторонами кирпича
Причем стены кирпича тоже предлагается упорядочить
Т.е. самую маленькую сторону кирпича сравнивать с меньшей стороной дырки
Вторую маленькую сторону кирпича сравнивать с большей стороной дырки
Сортировку 3 чисел предлагает делать пузырьком
 */