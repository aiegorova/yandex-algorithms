package com.yandexcontest.algorithms02.increaselist;

// 2 A

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        if (data.length == 0)
            System.out.println("NO");
        else {

            String result = "YES";
            int prev = Integer.parseInt(data[0]);
            for (int i = 1; i < data.length; i++) {
                int curr = Integer.parseInt(data[i]);
                if (prev >= curr) {
                    result = "NO";
                    break;
                }
                prev = curr;
            }
            System.out.println(result);
        }

    }
}

/*
Дан список. Определите, является ли он монотонно возрастающим(то есть верно ли, что каждый элемент этого списка больше предыдущего).

Выведите YES, если массив монотонно возрастает и NO в противном случае.

Пример 1
Ввод	Вывод
1 7 9
YES
Пример 2
Ввод	Вывод
1 9 7
NO
Пример 3
Ввод	Вывод
2 2 2
NO
 */