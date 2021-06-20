package com.yandexalgorithms.testcontest.C_dublicates;

// 1 C

import java.io.*;

public class Solution {

    public static char[] chars = new char[12];
    public static char[] lastChars = new char[12];

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("input.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("output.txt");
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            int n = Integer.parseInt(bufferedReader.readLine());

            for (int i = 0; i < n; i++) {

                readValue(bufferedReader, bufferedWriter);

            }

        } catch (Exception e) {

        }
    }

    public static void readValue(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {

        char ch;
        int i = 0;
        while ((ch = (char) bufferedReader.read()) != '\n') {
            chars[i] = ch;
            i++;
        }
        chars[i] = '\n';

        if (!areEqual()) {
            i = 0;
            for (char ch1 : chars) {
                if (ch1 == '\n') {
                    lastChars[i] = '\n';
                    break;
                }
                bufferedWriter.write(ch1);
                lastChars[i] = ch1;
                i++;
            }
            bufferedWriter.newLine();
        }

    }

    public static boolean areEqual() {

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != lastChars[i])
                return false;
            if (chars[i] == '\n' || lastChars[i] == '\n')
                break;

        }
        return true;

    }

}
