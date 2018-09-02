package array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * <p>
 * 示例:
 * <p>
 * 输入: s = 7, nums = [2,3,1,2,4,3]
 * 输出: 2
 * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 进阶:
 * <p>
 * 如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinSubArrayLen {

    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 2, 4, 3};
       int[] nums = {7};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int st = 0, end = 0, sum = 0, minLen = Integer.MAX_VALUE;
        final int len = nums.length;

        // 指针相遇停止
        while (st <= end) {
            if (sum < s) {
                // 后面的指针后移
                if (end < len) {
                    sum += nums[end];
                    end++;
                }else{
                    break;
                }
            } else {
                sum -= nums[st];
                st ++;
            }

            //
            if (sum >= s) {
                //System.out.println(st + "," + end+","+ sum);
                if ((end - st) < minLen) {
                    minLen = end - st;
                }
            }
        }

        // 找不到
        if(minLen == Integer.MAX_VALUE){
            return 0;
        }

        return minLen;
    }

    //TODO 别人做的最快的
    public int minSubArrayLen2(int s, int[] nums) {
        int n = nums.length;
        if(n == 0)
            return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = n + 1;
        while(right < n) {
            while(sum < s && right < n) {
                sum += nums[right ++];
            }
            while(sum >= s && left < right) {
                sum -= nums[left ++];
            }
            len = Math.min(len, right - left + 1);
        }
        return len == n + 1 ? 0 : len;
    }
}
