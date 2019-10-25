
# level2

## A04 Longest Increasing Subsequence

给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

[LeetCode 题解之 300. Longest Increasing Subsequence（最长上升子序列 LIS） - 李威威的博客 - CSDN博客](https://blog.csdn.net/lw_power/article/details/80758674)

不要追求完美，这样就可以了。

```java
    public int lengthOfLIS(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }

        int[] dp = new int[nums.length];

        // 初始化为1
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        // 最低是1
        int maxLenth = 1;

        for (int i = 1; i < nums.length; i++) {
            // 找之前所有里面最大的
            for (int j = i; j >= 0 ; j--) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLenth = Math.max(dp[i], maxLenth);
                }
            }
        }

        return maxLenth;
    }
```
