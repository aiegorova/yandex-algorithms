package com.yandexcontest.algorithms04.I_accentcheck;

// 4 I

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            HashMap<String, ArrayList<String>> dict = new HashMap<>();

            int n = Integer.parseInt(reader.readLine());
            for (int i = 0; i < n; i++) {
                String word = reader.readLine();
                String lowerWord = word.toLowerCase();
                if (!dict.containsKey(lowerWord))
                    dict.put(lowerWord, new ArrayList<>());
                dict.get(lowerWord).add(word);
            }

            int mistakes = 0;
            String[] data = reader.readLine().split(" ");
            for (int i = 0; i < data.length; i++) {

                if (data[i].isEmpty())
                    continue;
                String lowerWord = data[i].toLowerCase();
                if (dict.containsKey(lowerWord)) {
                    if (!dict.get(lowerWord).contains(data[i]))
                        mistakes++;

                } else {

                    int amountUpper = 0;
                    for (char ch : data[i].toCharArray()) {
                        if (Character.isUpperCase(ch))
                            amountUpper++;
                    }
                    if (amountUpper != 1)
                        mistakes++;

                }
            }

            writer.write("" + mistakes);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
После разбора:
решено также
 */