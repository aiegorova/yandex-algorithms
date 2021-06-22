package com.yandexcontest.algorithms01.G_details;

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
