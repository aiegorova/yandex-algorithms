package com.yandexcontest.algorithms01.F_notebooks;

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
