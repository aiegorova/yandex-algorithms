package com.yandexcontest.leetcode.reverseinteger;

public class Solution {

    public static void main(String[] args) {

        System.out.println(reverse(-123456789));

    }

    public static int reverse(int x) {
        int digit = 0, result = 0;
        while (x != 0) {
            int mod = x % 10;

            if (digit > 8) {
                if (result > 214748364 || result < -214748364)
                    return 0;
                else if (result == 214748364 && mod > 7 || result == -214748364 && mod > 8)
                    return 0;
            }

            result = result * 10 + mod;
            digit++;
            x = x / 10;
        }
        return result;
    }

}
