package com.yandexcontest.leetcode.twosum;

public class Solution {

    public static void main(String[] args) {

        System.out.println(twoSum(new int[]{1, 2, 3}, 3));

    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target)
                    return new int[]{i, j};
            }
        }
        return new int[2];

    }

}
