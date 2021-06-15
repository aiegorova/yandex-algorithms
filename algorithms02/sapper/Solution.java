package com.yandexcontest.algorithms02.sapper;

// 2 I

import java.io.*;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            Object[] data = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::parseInt).toArray();

            int linesAmount = (int) data[0];
            int columnsAmount = (int) data[1];
            int minesAmount = (int) data[2];

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
Вам необходимо построить поле для игры "Сапер" по его конфигурации – размерам и координатам расставленных на нем мин.

Вкратце напомним правила построения поля для игры "Сапер":

Поле состоит из клеток с минами и пустых клеток
Клетки с миной обозначаются символом *
Пустые клетки содержат число ki,j, 0≤ ki, j ≤ 8 – количество мин на соседних клетках. Соседними клетками являются восемь клеток, имеющих смежный угол или сторону.
Формат ввода
В первой строке содержатся три числа: N, 1 ≤ N ≤ 100 - количество строк на поле, M, 1 ≤ M ≤ 100 - количество столбцов на поле, K, 0 ≤ K ≤ N ⋅ M - количество мин на поле.

В следующих K строках содержатся по два числа с координатами мин: p, 1 ≤ p ≤ N - номер строки мины, q, 1 ≤ 1 ≤ M - номер столбца мины.

Формат вывода
Выведите построенное поле, разделяя строки поля переводом строки, а столбцы - пробелом.

Пример 1
Ввод	Вывод
3 2 2
1 1
2 2
* 2
2 *
1 1
Пример 2
Ввод	Вывод
2 2 0
0 0
0 0
Пример 3
Ввод	Вывод
4 4 4
1 3
2 1
4 2
4 4
1 2 * 1
* 2 1 1
2 2 2 1
1 * 2 *

После разбора:
Предлагает вместо проверки на предел поля добавить рамочку в поле
т.е. добавить по 1 строке сверху и снизу и по 1 столбцу слева и справа
Тогда и легче будет восприниматься нумерация, т.к. она будет с 1
Только не забыть при выводе не обходить рамочку

Вместо того, чтобы высчитывать отдельно координаты 8 клеток, лучше завести отдельно 2 массива длины 8 с -1, 0 и 1
и прибавлять их значения к координатам мины
 */