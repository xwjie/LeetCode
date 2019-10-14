# Level 1

## 01 删除排好顺序的数组的重复数

返回结果记得加1

## 02 买卖股票

和最牛逼的相差十万八千里

```java
    public int maxProfit(int[] prices) {
        int max = 0;
        int size = prices.length;
        for (int i = 0; i < size - 1; ++i)
            if (prices[i] < prices[i + 1])
                max += prices[i + 1] - prices[i];
        return max;
    }
```

## 03 旋转数组

一下子没有做出来！！

## 04 判断重复

[算法题：判断数组中是否存在重复出现的数 - sweetgirl520的博客 - CSDN博客](https://blog.csdn.net/sweetgirl520/article/details/51066286)

## 05 求只出现一次的数字，其他都是2次

[“求只出现一次的数字”系列算法问题 - 知乎](https://zhuanlan.zhihu.com/p/85719238)

## 06   两个数组的交集 II

先排序，双指针。然后list存放数据。

# level 2

## A03 字谜分组

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
]

> 把字符串排序，做为key放入map遍历即可。

## 04  无重复字符的最长子串 `滑动窗口`

[leetcode No.3 无重复字符的最长子串 - 知乎](https://zhuanlan.zhihu.com/p/76695630)

## 05 最长回文子串

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

[LeetCode 5. 最长回文子串](https://mp.weixin.qq.com/s?src=11&timestamp=1570891440&ver=1908&signature=TOLCa84BACqCh5yU-IVu9XhCBRXUTrhmaYcU-0r*BaZSU8dw5CYAWptz7fBFYgH0EGncffCQzl357aPVPYSXZQwCxY9ak*4jt6Am3RJdTkgf3eNrpQm8Dexsv2I4frjd&new=1)



## 06 递增的三元子序列

给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。

[递增的三元子序列 - Random的博客 - CSDN博客](https://blog.csdn.net/random_r/article/details/100111050)
