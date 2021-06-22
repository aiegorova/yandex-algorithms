package com.yandexcontest.algorithms02.I_sapper;

// 2 I

import java.io.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int[] data = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int linesAmount = data[0];
            int columnsAmount = data[1];
            int minesAmount = data[2];

            int[][] field = new int[linesAmount][columnsAmount];

            for (int i = 0; i < minesAmount; i++) {
                String[] coords = reader.readLine().split(" ");
                int line = Integer.parseInt(coords[0]);
                int column = Integer.parseInt(coords[1]);

                field[line - 1][column - 1] = -9;

                if (line > 1) {
                    if (column > 1)
                        field[line - 2][column - 2]++;
                    field[line - 2][column - 1]++;
                    if (column < columnsAmount)
                        field[line - 2][column]++;
                }

                if (column > 1)
                    field[line - 1][column - 2]++;
                if (column < columnsAmount)
                    field[line - 1][column]++;

                if (line < linesAmount) {
                    if (column > 1)
                        field[line][column - 2]++;
                    field[line][column - 1]++;
                    if (column < columnsAmount)
                        field[line][column]++;
                }

            }

            for (int line = 0; line < linesAmount; line++) {
                for (int column = 0; column < columnsAmount; column++) {
                    writer.write("" + (field[line][column] < 0 ? "*" : field[line][column]) + " ");
                }
                writer.write("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
После разбора:
Предлагает вместо проверки на предел поля добавить рамочку в поле
т.е. добавить по 1 строке сверху и снизу и по 1 столбцу слева и справа
Тогда и легче будет восприниматься нумерация, т.к. она будет с 1
Только не забыть при выводе не обходить рамочку

Вместо того, чтобы высчитывать отдельно координаты 8 клеток, лучше завести отдельно 2 массива длины 8 с -1, 0 и 1
и прибавлять их значения к координатам мины
 */