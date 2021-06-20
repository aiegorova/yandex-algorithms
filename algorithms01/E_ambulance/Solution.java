package com.yandexalgorithms.algorithms01.E_ambulance;

// 1 E

import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] data = scanner.nextLine().split(" ");
        int currFlat = Integer.parseInt(data[0]);
        int floorsAmount = Integer.parseInt(data[1]);
        int prevFlat = Integer.parseInt(data[2]);
        int prevSection = Integer.parseInt(data[3]);
        int prevFloor = Integer.parseInt(data[4]);

        int currSection = 0, currFloor = 0;

        if (prevSection == 1 && prevFloor == 1) {

            if (currFlat <= prevFlat) {
                currSection = 1;
                currFloor = 1;
            } else if (floorsAmount == 1)
                currFloor = 1;
            else if (currFlat <= prevFlat * floorsAmount)
                currSection = 1;

        } else {

            int upperBound = (int) Math.floor(1.0 * (prevFlat - 1) / ((prevSection - 1) * floorsAmount + (prevFloor - 1))); // x <=
            int lowerBound = (int) Math.ceil(1.0 * prevFlat / ((prevSection - 1) * floorsAmount + prevFloor)); // x >=

            if (upperBound < lowerBound || upperBound <= 0 || prevFloor > floorsAmount) {
                currSection = -1;
                currFloor = -1;
            } else {

                int section1 = (int) Math.ceil(1.0 * currFlat / lowerBound / floorsAmount);
                int section2 = (int) Math.ceil(1.0 * currFlat / upperBound / floorsAmount);

                currSection = section1 == section2 ? section1 : 0;

                int floor1 = (int) Math.ceil(1.0 * (currFlat - (section1 - 1) * lowerBound * floorsAmount) / lowerBound);
                int floor2 = (int) Math.ceil(1.0 * (currFlat - (section2 - 1) * upperBound * floorsAmount) / upperBound);

                currFloor = floor1 == floor2 ? floor1 : 0;

            }

        }

        System.out.printf("%d %d", currSection, currFloor);

    }

}

/*
Ломалось на:
10 3 50 1 50
 */