package dp;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        //int[] nums = {-2};
        //int[] nums = {-2, 1};
        // int[] nums = {-2, -1};
        int[] nums = {-2, -1, -3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int finalMax = Integer.MIN_VALUE, lastMax = 0;

        for (int i = 0; i < nums.length; i++) {
            // 更新最大值
            finalMax = Math.max(finalMax, nums[i] + lastMax);

            // 如果加上当前值大于0就留着（有用），否则（没有用）设置为0
            lastMax = Math.max(0, nums[i] + lastMax);
        }

        return finalMax;
    }

}
