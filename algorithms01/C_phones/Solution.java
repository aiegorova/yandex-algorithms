package com.yandexcontest.algorithms01.C_phones;

// 1 C

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;


public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
             BufferedReader reader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
             BufferedWriter writer = new BufferedWriter(fileWriter)) {

            StringBuilder phone = new StringBuilder(reader.readLine().replaceAll("[^0-9]", ""));
            if (phone.length() > 10)
                phone.delete(0, phone.length() - 10);
            else if (phone.length() < 10)
                phone.insert(0, "495");

            for (int i = 0; i < 3; i++) {
                StringBuilder existingPhone = new StringBuilder(reader.readLine().replaceAll("[^0-9]", ""));
                if (existingPhone.length() > 10)
                    existingPhone.delete(0, existingPhone.length() - 10);
                else if (existingPhone.length() < 10)
                    existingPhone.insert(0, "495");
                if (existingPhone.toString().equals(phone.toString()))
                    writer.write("YES\n");
                else
                    writer.write("NO\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
