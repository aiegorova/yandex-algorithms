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
                if (dict.containsKey(lowerWord))
                    dict.get(lowerWord).add(word);
                else {
                    ArrayList<String> versions = new ArrayList<>();
                    versions.add(word);
                    dict.put(lowerWord, versions);
                }
            }

            int mistakes = 0;
            String[] data = reader.readLine().split(" ");
            for (int i = 0; i < data.length; i++) {

                if (data[i].isEmpty())
                    continue;
                ArrayList<String> versions = dict.get(data[i].toLowerCase());
                if (versions != null && !versions.contains(data[i])) {

                    mistakes++;

                } else if (versions == null) {

                    int amountUpper = 0;
                    for (int j = 0; j < data[i].length(); j++) {
                        if (data[i].charAt(j) <= 90)
                            amountUpper++;
                    }
                    if (amountUpper == 0 || amountUpper > 1)
                        mistakes++;

                }
            }

            writer.write("" + mistakes);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
