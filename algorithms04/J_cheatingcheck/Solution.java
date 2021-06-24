package com.yandexcontest.algorithms04.J_cheatingcheck;

// 4 J

import java.io.*;
import java.util.HashSet;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String[] data = reader.readLine().split(" ");
            int amountOfKeys = Integer.parseInt(data[0]);
            boolean isCaseSensitive = data[1].equals("yes") ? true : false;
            boolean canStartFromNumber = data[2].equals("yes") ? true : false;

            HashSet<String> dict = new HashSet<>();
            for (int i = 0; i < amountOfKeys; i++) {
                dict.add(isCaseSensitive ? reader.readLine() : reader.readLine().toLowerCase());
            }

            String result = "";
            int max = 0, minLine = -1, minIndex = -1;
            HashMap<String, Integer[]> map = new HashMap<>();
            while (reader.ready()) {

                data = reader.readLine().split(" ");
                for (int i = 0; i < data.length; i++) {

                    if (data[i].isEmpty())
                        continue;
                    else {

                        int amountOfLetters = 0, start = -1, end = -1;
                        for (int j = 0; j < data[i].length(); j++) {
                            if (Character.isLetter(data[i].charAt(j)) || data[i].charAt(j) == '_')
                                amountOfLetters++;
                            else if (!Character.isDigit(data[i].charAt(j))) {
                                if (amountOfLetters > 0 && (canStartFromNumber || !Character.isDigit(data[i].charAt(start)))) {

                                    String key = isCaseSensitive ? data[i].substring(start, end + 1) : data[i].substring(start, end + 1).toLowerCase();
                                    if (!dict.contains(key)) {
                                        if (!map.containsKey(key))
                                            map.put(key, new Integer[]{i, start, 0});
                                        map.get(key)[2] += 1;

                                        Integer[] arr = map.get(key);
                                        if (arr[2] > max || arr[2] == max
                                                && (minLine == -1 || arr[0] < minLine || arr[0] == minLine && arr[1] < minIndex)) {
                                            max = arr[2];
                                            minLine = arr[0];
                                            minIndex = arr[1];
                                            result = data[i].substring(start, end + 1);
                                        }
                                    }
                                }
                                start = -1;
                                end = -1;
                                amountOfLetters = 0;
                                continue;
                            }
                            start = start == -1 ? j : start;
                            end = j;
                        }

                        if (amountOfLetters > 0 && (canStartFromNumber || !Character.isDigit(data[i].charAt(start)))) {

                            String key = isCaseSensitive ? data[i].substring(start, end + 1) : data[i].substring(start, end + 1).toLowerCase();
                            if (!dict.contains(key)) {
                                if (!map.containsKey(key))
                                    map.put(key, new Integer[]{i, start, 0});
                                map.get(key)[2] += 1;

                                Integer[] arr = map.get(key);
                                if (arr[2] > max || arr[2] == max
                                        && (minLine == -1 || arr[0] < minLine || arr[0] == minLine && arr[1] < minIndex)) {
                                    max = arr[2];
                                    minLine = arr[0];
                                    minIndex = arr[1];
                                    result = data[i].substring(start, end + 1);
                                }
                            }
                        }

                    }

                }

            }

            writer.write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

/*
После разбора:
решено также, кроме выкидывания прочих символов из строки и замены их на пробелы
и дальнейшего нарезания строк по пробелам
и кроме сквозного счетчика слов
желательно переделать на вызов функций, чтобы не было дублирования кода
 */