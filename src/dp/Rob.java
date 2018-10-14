package dp;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/23/dynamic-programming/57/
 */
public class Rob {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {2,7,9,3,1};

        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int[] valus = new int[nums.length];


        if (nums.length == 1) {
            return nums[0];
        }

        valus[0] = nums[0];

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        valus[1] = nums[1];

        valus[2] = nums[2] + nums[0];

        for (int i = 3; i < nums.length; i++) {
            valus[i] = nums[i] + Math.max(valus[i - 2], valus[i - 3]);
        }

        // 注意
        return Math.max(valus[valus.length - 2], valus[valus.length - 1]);
    }
}
