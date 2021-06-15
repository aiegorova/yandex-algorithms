package com.yandexcontest.algorithms02.symmetricsequence;

// 2 F

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            List<Integer> data = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).collect(Collectors.toList());

            int result = findSymmetricValues(data, n);

            writer.write("" + result);
            if (result > 0)
                writer.write("\n");
            for (int i = 0; i < result; i++) {
                writer.write("" + data.get(result - i - 1) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int findSymmetricValues(List<Integer> list, int n) {

        int amount = 0;

        for (int i = 0; i < n - 1; i++) {

            if (i >= n/2 && amount == 0)
                break;

            if (list.get(i) != list.get(n - 1 - i + amount))
                amount = i + 1;

        }

        return amount;

    }
}

/*
Последовательность чисел назовем симметричной, если она одинаково читается как слева направо, так и справа налево. Например, следующие последовательности являются симметричными: 1 2 3 4 5 4 3 2 1 1 2 1 2 2 1 2 1 Вашей программе будет дана последовательность чисел. Требуется определить, какое минимальное количество и каких чисел надо приписать в конец этой последовательности, чтобы она стала симметричной.

Формат ввода
Сначала вводится число N — количество элементов исходной последовательности (1 ≤ N ≤ 100). Далее идут N чисел — элементы этой последовательности, натуральные числа от 1 до 9.

Формат вывода
Выведите сначала число M — минимальное количество элементов, которое надо дописать к последовательности, а потом M чисел (каждое — от 1 до 9) — числа, которые надо дописать к последовательности.

Пример 1
Ввод	Вывод
9
1 2 3 4 5 4 3 2 1
0
Пример 2
Ввод	Вывод
5
1 2 1 2 2
3
1 2 1
Пример 3
Ввод	Вывод
5
1 2 3 4 5
4
4 3 2 1
 */