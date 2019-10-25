package list.level3;

import list.ListNode;

/**
 * 合并K个元素的有序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class A01mergeKLists {
    public static void main(String[] args) {
        ListNode node1 = ListNode.createList(1,4,5);
        ListNode node2 = ListNode.createList(1,3,4);
        ListNode node3 = ListNode.createList(2,6);

        System.out.println(mergeKLists(node1,node2,node3));
    }

    public static ListNode mergeKLists(ListNode... lists) {
        ListNode root = null;

        for (int i = 0; i < lists.length; i++) {
            root = merge2List(root, lists[i]);
        }

        return root;
    }

    public static ListNode merge2List(ListNode left, ListNode right) {
        if(left == null ){
            return right;
        }

        if(right == null){
            return left;
        }

        ListNode root = null, tail = null;

        while(left != null && right != null) {
            if (left.val < right.val) {
                if (tail != null) {
                    tail.next = left;
                }
                else{
                    root = left;
                }

                tail = left;
                left = left.next;
            }else{
                if (tail != null) {
                    tail.next = right;
                }
                else{
                    root = right;
                }

                tail = right;
                right = right.next;
            }
        }

        // 尾巴把剩下的指过去
        if(left == null){
            tail.next = right;
        }
        else {
            tail.next = left;
        }

        return root;
    }
}
