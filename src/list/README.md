# level2

## 02 奇偶链表

给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

这道题给了我们一个链表，让我们分开奇偶节点，所有奇节点在前，偶节点在后。我们可以使用两个指针来做，pre指向奇节点，cur指向偶节点，然后把偶节点cur后面的那个奇节点提前到pre的后面，然后pre和cur各自前进一步，此时cur又指向偶节点，pre指向当前奇节点的末尾，以此类推直至把所有的偶节点都提前了即可

[[LeetCode] Odd Even Linked List 奇偶链表 - Grandyang - 博客园](https://www.cnblogs.com/grandyang/p/5138936.html)

## 03 相交链表

没有看懂题目

- 值相同，不代表节点是同一个。所以不能判断value，要直接判断地址，用 == 

这个思路就是 ListA + ListB = A + intersection + Bb + intersection，ListB + ListA = Bb + intersection + A + intersection。用大A表示ListA里面非共有 Bb表示listB里面非共有的，可以看到在第二个intersection的开头两个链表长度是一样的，必然相等。所以我们可以遍历A再遍历B，另一个遍历B再遍历A，两个指针必定在第二个交集处相遇，没有交集就是空指针。

[相交链表 - 知乎](https://zhuanlan.zhihu.com/p/48313122)

https://mp.weixin.qq.com/s?src=11&timestamp=1570936499&ver=1909&signature=VbGOzitEJXH9OyFZmgJN1NDU982a0-8vWhBBgG9gUL0W6ffJ-ZdFVpSDsgrQ9sZxB3mgANddZ4M-a5HnJZgupd3Qr7l2*9bGZ64u-E*iuJxjxUSjYN*sIebX*MT*Avi3&new=1