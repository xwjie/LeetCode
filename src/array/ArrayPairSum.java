package array;

import java.util.Arrays;

/**
 * 题目要求：给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 *
 * 思路：由题意可知，所求数应为a1+a2+...an总和最大.比较简便的做法就是，先将数组排序，计算奇数项之和。
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,4,3,2}));
    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i +=2) {
            sum += nums[i];
        }

        return sum;
    }
}
