# level2

## 04 完美二叉树填充每个节点的下一个右侧节点指针

不完美的看这里

[【Leetcode】117. 填充每个节点的下一个右侧节点指针 II](https://mp.weixin.qq.com/s?src=11&timestamp=1570941335&ver=1909&signature=7ls7Qa9omfBgdZwEx4AUCkhYQx2IKAgBTfCU6rTYSvRB7pSqvRkJZxCB4JwtkldOFqsiT7tkMRFvCB4BkqaW1c0mDQzrrq1LecW6JcpEJb2KxHjn4K2nVXCJ*JfZncgx&new=1)

## 05 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。


下面的算法不需要保存全部的值，一个全局变量保存了当前次数。

```java
class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        
        int left = kthSmallest(root.left,k);
        
        if(count == k){
            return left;
        }
        
        count++;
        
        if(count == k){
            return root.val;
        }
        
        int right = kthSmallest(root.right,k);
        
        return right;
    }
}
```