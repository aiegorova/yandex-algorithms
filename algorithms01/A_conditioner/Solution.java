package com.yandexcontest.algorithms01.A_conditioner;

// 1 A

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        String typeFreeze = "freeze";
        String typeHeat = "heat";
        String typeAuto = "auto";
        String typeFan = "fan";

        Scanner scanner = new Scanner(System.in);
        String[] temps = scanner.nextLine().split(" ");
        int tempRoom = Integer.parseInt(temps[0]);
        int tempDesire = Integer.parseInt(temps[1]);

        String type = scanner.nextLine();

        if (type.equals(typeAuto)
                || tempRoom <= tempDesire && type.equals(typeHeat)
                || tempRoom >= tempDesire && type.equals(typeFreeze))
            System.out.println(tempDesire);
        else
            System.out.println(tempRoom);

    }
}