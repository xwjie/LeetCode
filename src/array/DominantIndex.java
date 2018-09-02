package array;

/**
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * <p>
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * <p>
 * 如果是，则返回最大元素的索引，否则返回-1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * <p>
 * <p>
 * 提示:
 * <p>
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/771/
 */
public class DominantIndex {
    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        //int[] nums = {0,0,2,1};
        //int[] nums = {0,0,3,2};
        System.out.println(dominantIndex(nums));
    }

    public static int dominantIndex(int[] nums) {
        int max = -1, sencond = -1;
        int maxIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                sencond = max;
                max = nums[i];
                maxIndex = i;
            } else if (nums[i] > sencond) {
                sencond = nums[i];
            }
        }

        return max >= sencond << 1 ? maxIndex : -1;
    }
}
