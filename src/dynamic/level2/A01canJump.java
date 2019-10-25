package dynamic.level2;

/**
 * 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 */
public class A01canJump {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }

        boolean[] result = new boolean[nums.length];

        result[0] = true;

        for (int i = 0; i < nums.length; i++) {
            if (!result[i]) {
                return false;
            }

            for (int j = 0; j < nums[i]; j++) {
                // 需要加1
                if (j + i + 1 < nums.length) {
                    result[j + i + 1] = true;
                }
            }
        }

        return result[nums.length - 1];
    }
}
