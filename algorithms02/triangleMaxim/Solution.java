package com.yandexcontest.algorithms02.triangleMaxim;

// 2 J

import java.io.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("C:\\\\Java\\input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter("C:\\\\Java\\output.txt");
            BufferedWriter writer = new BufferedWriter(fileWriter)) {

            String typeCloser = "closer";

            int amount = Integer.parseInt(reader.readLine());
            double lowerBound = 30.0;
            double upperBound = 4000.0;
            double prevValue = Double.parseDouble(reader.readLine());

            for (int i = 1; i < amount; i++) {

                String[] data = reader.readLine().split(" ");
                double currValue = Double.parseDouble(data[0]);

                if (data[1].equals(typeCloser)) {

                    if (currValue <= prevValue)
                        upperBound = Math.min(upperBound, currValue + (prevValue - currValue) / 2);
                    else
                        lowerBound = Math.max(lowerBound, currValue - (currValue - prevValue) / 2);

                } else {

                    if (currValue <= prevValue)
                        lowerBound = Math.max(lowerBound, prevValue - (prevValue - currValue) / 2);
                    else
                        upperBound = Math.min(upperBound, prevValue + (currValue - prevValue) / 2);

                }

                prevValue = currValue;

            }

            writer.write(String.format("%6f %6f", lowerBound, upperBound));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

/*
С детства Максим был неплохим музыкантом и мастером на все руки. Недавно он самостоятельно сделал несложный перкуссионный музыкальный инструмент — треугольник. Ему нужно узнать, какова частота звука, издаваемого его инструментом.

У Максима есть профессиональный музыкальный тюнер, с помощью которого можно проигрывать ноту с заданной частотой. Максим действует следующим образом: он включает на тюнере ноты с разными частотами и для каждой ноты на слух определяет, ближе или дальше она к издаваемому треугольником звуку, чем предыдущая нота. Поскольку слух у Максима абсолютный, он определяет это всегда абсолютно верно.

Вам Максим показал запись, в которой приведена последовательность частот, выставляемых им на тюнере, и про каждую ноту, начиная со второй, записано — ближе или дальше она к звуку треугольника, чем предыдущая нота. Заранее известно, что частота звучания треугольника Максима составляет не менее 30 герц и не более 4000 герц.

Требуется написать программу, которая определяет, в каком интервале может находиться частота звучания треугольника.

Формат ввода
Первая строка входного файла содержит целое число n — количество нот, которые воспроизводил Максим с помощью тюнера (2 ≤ n ≤ 1000). Последующие n строк содержат записи Максима, причём каждая строка содержит две компоненты: вещественное число fi — частоту, выставленную на тюнере, в герцах (30 ≤ fi ≤ 4000), и слово «closer» или слово «further» для каждой частоты, кроме первой.

Слово «closer» означает, что частота данной ноты ближе к частоте звучания треугольника, чем частота предыдущей ноты, что формально описывается соотношением: |fi − ftriangle| < |fi − 1 − ftriangle| .

Слово «further» означает, что частота данной ноты дальше, чем предыдущая.

Если оказалось, что очередная нота так же близка к звуку треугольника, как и предыдущая нота, то Максим мог записать любое из двух указанных выше слов.

Гарантируется, что результаты, полученные Максимом, непротиворечивы.

Формат вывода
В выходной файл необходимо вывести через пробел два вещественных числа — наименьшее и наибольшее возможное значение частоты звучания треугольника, изготовленного Максимом. Числа должны быть выведены с точностью не хуже 10−6.

Пример 1
Ввод	Вывод
3
440
220 closer
300 further
30.0 260.0
Пример 2
Ввод	Вывод
4
554
880 further
440 closer
622 closer
531.0 660.0

После разбора:
решено также
 */