package com.yandexcontest.algorithms02.sequencetype;

// 2 B

import java.io.*;

public class Solution {

    public static void main(String[] args) {

        int finish = -2000000000;
        boolean constant = true;
        boolean ascending = true;
        boolean weaklyAscending = true;
        boolean descending = true;
        boolean weaklyDescending = true;

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int prevValue = Integer.parseInt(reader.readLine());
            if (prevValue == finish) {
                writer.write("RANDOM");
                return;
            }

            int currValue = Integer.parseInt(reader.readLine());
            if (currValue == finish) {
                writer.write("RANDOM");
                return;
            }

            while (currValue != finish) {

                if (currValue != prevValue && constant)
                    constant = false;
                if (currValue <= prevValue && ascending)
                    ascending = false;
                if (currValue < prevValue && weaklyAscending)
                    weaklyAscending = false;
                if (currValue >= prevValue && descending)
                    descending = false;
                if (currValue > prevValue && weaklyDescending)
                    weaklyDescending = false;

                prevValue = currValue;
                currValue = Integer.parseInt(reader.readLine());

            }

            if (constant)
                writer.write("CONSTANT");
            else if (ascending)
                writer.write("ASCENDING");
            else if (descending)
                writer.write("DESCENDING");
            else if (weaklyAscending)
                writer.write("WEAKLY ASCENDING");
            else if (weaklyDescending)
                writer.write("WEAKLY DESCENDING");
            else
                writer.write("RANDOM");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
По последовательности чисел во входных данных определите ее вид:

CONSTANT – последовательность состоит из одинаковых значений
ASCENDING – последовательность является строго возрастающей
WEAKLY ASCENDING – последовательность является нестрого возрастающей
DESCENDING – последовательность является строго убывающей
WEAKLY DESCENDING – последовательность является нестрого убывающей
RANDOM – последовательность не принадлежит ни к одному из вышеупомянутых типов
Формат ввода
По одному на строке поступают числа последовательности ai, |ai| ≤ 109.

Признаком окончания последовательности является число -2× 109. Оно в последовательность не входит.

Формат вывода
В единственной строке выведите тип последовательности.

Пример
Ввод	Вывод
-530
-530
-530
-530
-530
-530
-2000000000
 */