package list.level3;

import list.ListNode;

import java.util.Arrays;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 */
public class A02sortList {
    public static void main(String[] args) {
        ListNode node = ListNode.createList(-1, 5, 3, 4, 0);
        System.out.println(sortList(node));
    }

    public static ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode p = head;

        int count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }

        int[] values = new int[count];

        p = head;
        int i = 0;
        while (p != null) {
            values[i++] = p.val;
            p = p.next;
        }

        Arrays.sort(values);

        p = head;
        i = 0;
        while (p != null) {
            p.val = values[i++];
            p = p.next;
        }

        return head;
    }

    /**
     * 三分分治排序
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        // 第一个值为中间值
        final int val = head.val;

        // 冗余的头结点
        final ListNode left = new ListNode(-1);
        final ListNode mid = new ListNode(-1);
        final ListNode right = new ListNode(-1);

        ListNode l = left, m = mid, r = right;

        // 分成3份
        while (head != null) {
            if (head.val < val) {
                l.next = head;
                l = l.next;
            } else if (head.val > val) {
                r.next = head;
                r = r.next;
            } else {
                m.next = head;
                m = m.next;
            }

            head = head.next;
        }

        l.next = null;
        r.next = null;

        // 左右排序，中间是相同的不需要排序。
        left.next = sortList(left.next);
        right.next = sortList(right.next);

        // 左边的最后一个指针
        l = left;
        while (l.next != null) l = l.next;

        // 三个拼接起来
        l.next = mid.next;
        m.next = right.next;

        return left.next;
    }

}
