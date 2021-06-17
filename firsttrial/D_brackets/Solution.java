package com.yandexcontest.firsttrial.D_brackets;

// D

import java.io.*;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader)) {

            int n = Integer.parseInt(reader.readLine());

            char[] chars = new char[2 * n];
            createString(chars, 0, 0, n);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void createString(char[] chars, int countLeft, int countRight, int countPairs) {

        if (countLeft == countPairs && countRight == countPairs) {
            System.out.println(chars);
        } else {
            if (countLeft < countPairs) {
                chars[countLeft + countRight] = '(';
                createString(chars, countLeft + 1, countRight, countPairs);
            }
            if (countRight < countLeft) {
                chars[countLeft + countRight] = ')';
                createString(chars, countLeft, countRight + 1, countPairs);
            }
        }

    }

}
