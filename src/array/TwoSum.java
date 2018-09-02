package array;

import java.util.Arrays;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(numbers, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int st = 0;
        int end = numbers.length - 1;

        while (st < end) {
            int sum = numbers[st] + numbers[end];

            if (sum == target) {
               break;
            } else if (sum > target) {
                end--;
            } else {
                st++;
            }
        }

        return new int[]{st + 1, end + 1};
    }
}
