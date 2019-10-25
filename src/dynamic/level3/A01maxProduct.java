package dynamic.level3;

/**
 * 乘积最大子序列
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 * <p>
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class A01maxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, -4}));
        System.out.println(maxProduct(new int[]{2, 3, -2, -4, 0}));
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
        System.out.println(maxProduct(new int[]{2, -1, 1, 1}));
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3}));
    }

    public static int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];

        if (nums[0] > 0) {
            dpMax[0] = nums[0];
        } else {
            dpMin[0] = nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > 0){
                dpMax[i] = dpMax[i - 1] * nums[i];
                dpMin[i] = dpMin[i - 1] * nums[i];
            }
            else{
                dpMax[i] = dpMin[i - 1] * nums[i];
                dpMin[i] = dpMax[i - 1] * nums[i];
            }

            dpMin[i] = Math.min(dpMax[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < dpMax.length; i++) {
            max = Math.max(max, dpMax[i]);
        }

        return max;
    }
}
