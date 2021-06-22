package com.yandexcontest.algorithms04.G_bankaccounts;

// 4 G

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        String operationDeposit = "DEPOSIT";
        String operationWithdraw = "WITHDRAW";
        String operationTransfer = "TRANSFER";
        String operationIncome = "INCOME";
        String operationBalance = "BALANCE";
        String resultError = "ERROR\n";

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            HashMap<String, Long> map = new HashMap();

            while (reader.ready()) {

                String[] data = reader.readLine().split(" ");

                if (data[0].equals(operationDeposit)) {

                    Long value = map.putIfAbsent(data[1], Long.parseLong(data[2]));
                    if (value != null)
                        map.put(data[1], value + Long.parseLong(data[2]));

                } else if (data[0].equals(operationWithdraw)) {

                    Long value = map.putIfAbsent(data[1], -Long.parseLong(data[2]));
                    if (value != null)
                        map.put(data[1], value - Long.parseLong(data[2]));

                } else if (data[0].equals(operationTransfer)) {

                    Long value1 = map.putIfAbsent(data[1], -Long.parseLong(data[3]));
                    Long value2 = map.putIfAbsent(data[2], Long.parseLong(data[3]));
                    if (value1 != null)
                        map.put(data[1], value1 - Long.parseLong(data[3]));
                    if (value2 != null)
                        map.put(data[2], value2 + Long.parseLong(data[3]));

                } else if (data[0].equals(operationIncome)) {

                    for (Map.Entry<String, Long> entry : map.entrySet()) {
                        if (entry.getValue() >= 0)
                            entry.setValue(entry.getValue() + Integer.parseInt(data[1]) * entry.getValue() / 100);
                    }

                } else if (data[0].equals(operationBalance)) {

                    if (!map.containsKey(data[1]))
                        writer.write(resultError);
                    else
                        writer.write("" + map.get(data[1]) + "\n");

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
