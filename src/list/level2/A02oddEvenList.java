package list.level2;

import list.ListNode;

import java.util.List;

public class A02oddEvenList {
    public static void main(String[] args) {
        ListNode node = ListNode.createList(new int[]{1, 2, 3, 4, 5, 6, 7});
        ListNode.print(oddEvenList(node));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) {
            return  head;
        }

        // pre指向奇节点，cur指向偶节点
        ListNode pre = head, cur = head.next;

        while(cur != null && cur.next!=null){
           ListNode n = pre.next;

           pre.next = cur.next;
           cur.next = cur.next.next;

           pre.next.next = n;

           pre = pre.next;
           cur = cur.next;
        }

        return head;
    }
}
