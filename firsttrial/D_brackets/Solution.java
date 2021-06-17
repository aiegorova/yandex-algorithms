package com.yandexcontest.firsttrial.D_brackets;

// D

import java.io.*;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(reader.readLine());

            char[] chars = new char[2 * n];

            long up = 1;
            long down = 1;
            for (int i = 1; i <= 2 * n; i++) {
                if (i <= n) {
                    chars[i - 1] = '(';
                    down *= i;
                } else
                    chars[i - 1] = ')';
                if (i > n + 1)
                    up *= i;
            }

            writer.write(chars);
            writer.write('\n');

            int amount = (int) (up / down);

            for (int count = 0; count < amount; count++) {

                int depth = 0;
                for (int i = 2 * n - 1; i >= 0; --i) {

                    if (chars[i] == '(')
                        --depth;
                    else
                        ++depth;
                    if (chars[i] == '(' && depth > 0) {
                        --depth;
                        int open = (2 * n - i - 1 - depth) / 2;
                        int close = 2 * n - i - 1 - open;
                        chars[i] = ')';
                        for (int j = 1; j <= open; j++) {
                            chars[i + j] = '(';
                        }
                        for (int j = 1; j <= close; j++) {
                            chars[i + open + j] = ')';
                        }
                        writer.write(chars);
                        writer.write('\n');
                        break;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
