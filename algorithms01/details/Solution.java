package com.yandexcontest.algorithms01.details;

// 1 G

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int weightMetal = Integer.parseInt(data[0]);
        int weightBlank = Integer.parseInt(data[1]);
        int weightDetail = Integer.parseInt(data[2]);

        int amountBlanks = 0;
        int excessMetal = weightBlank % weightDetail;
        while (weightMetal >= weightBlank && weightBlank >= weightDetail) {
            int amount = weightMetal / weightBlank;
            amountBlanks += amount;
            weightMetal = weightMetal % weightBlank + amount * excessMetal;
        }

        System.out.println(amountBlanks * (weightBlank / weightDetail));

    }
}

/*
Имеется N кг металлического сплава. Из него изготавливают заготовки массой K кг каждая. После этого из каждой заготовки вытачиваются детали массой M кг каждая (из каждой заготовки вытачивают максимально возможное количество деталей). Если от заготовок после этого что-то остается, то этот материал возвращают к началу производственного цикла и сплавляют с тем, что осталось при изготовлении заготовок. Если того сплава, который получился, достаточно для изготовления хотя бы одной заготовки, то из него снова изготавливают заготовки, из них – детали и т.д. Напишите программу, которая вычислит, какое количество деталей может быть получено по этой технологии из имеющихся исходно N кг сплава.

Формат ввода
Вводятся N, K, M. Все числа натуральные и не превосходят 200.

Формат вывода
Выведите одно число — количество деталей, которое может получиться по такой технологии.

Пример 1
Ввод	Вывод
10 5 2
4
Пример 2
Ввод	Вывод
13 5 3
3
Пример 3
Ввод	Вывод
14 5 3
4
 */