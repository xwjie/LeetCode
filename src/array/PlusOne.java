package array;
import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 输入：[9]
 * 预期：[1,0]
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/772/
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums = {9, 9};
        System.out.println(Arrays.toString(plusOne(nums)));
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // 到了这里表示全部都是9
        int[] num = new int[len + 1];
        num[0] = 1;

        return num;
    }
}
