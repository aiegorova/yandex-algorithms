package com.yandexcontest.algorithms01.notebooks;

// 1 F

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");

        int height1 = Integer.parseInt(data[0]);
        int width1 = Integer.parseInt(data[1]);
        int height2 = Integer.parseInt(data[2]);
        int width2 = Integer.parseInt(data[3]);

        ArrayList<Table> tables = new ArrayList<>();
        tables.add(new Table(width1 + width2, Math.max(height1, height2)));

        if (height2 != width2)
            tables.add(new Table(width1 + height2, Math.max(height1, width2)));

        if (height1 != width1)
            tables.add(new Table(height1 + width2, Math.max(width1, height2)));

        if (height1 != width1 && height2 != width2
            && !(height1 == width2 && width1 == height2) && !(height1 == height2 && width1 == width2))
            tables.add(new Table(height1 + height2, Math.max(width1, width2)));

        Table minTable = tables.stream().min((table1, table2) -> table1.getSquare() - table2.getSquare()).get();
        minTable.printSize();

    }

}

class Table {

    private int height;
    private int width;
    private int square;

    public Table(int height, int width) {

        this.height = height;
        this.width = width;
        square = height * width;

    }

    public void printSize() {

        System.out.printf("%d %d", height, width);
        System.out.println();

    }

    public int getSquare() {
        return square;
    }
}

/*
В школе решили на один прямоугольный стол поставить два прямоугольных ноутбука. Ноутбуки нужно поставить так, чтобы их стороны были параллельны сторонам стола. Определите, какие размеры должен иметь стол, чтобы оба ноутбука на него поместились, и площадь стола была минимальна.

Формат ввода
Вводится четыре натуральных числа, первые два задают размеры одного ноутбука, а следующие два — размеры второго. Числа не превышают 1000.

Формат вывода
Выведите два числа — размеры стола. Если возможно несколько ответов, выведите любой из них (но только один).

Пример 1
Ввод	Вывод
10 2 2 10
20 2
2 20
4 10
10 4
Пример 2
Ввод	Вывод
5 7 3 2
9 5
5 9
Примечания
В примерах указаны всевозможные ответы на поставленную задачу. Ваша программа должна вывести один из них.
 */