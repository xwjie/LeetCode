package list;

public class AddTwoNumbers {
    public static void main(String[] args) {

        ListNode l1 = ListNode.createList(new int[]{2, 4, 3});
        ListNode.print(l1);
        ListNode l2 = ListNode.createList(new int[]{5, 6, 6});
        ListNode.print(l2);

        ListNode result = addTwoNumbers(l1, l2);
        ListNode.print(result);
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = null, node = null;

        while (l1 != null || l2 != null) {
            int value = 0;

            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            if (root == null) {
                root = new ListNode(value);
                node = root;
            } else if (node.next == null) {
                node.next = new ListNode(value);
                node = node.next;
            }else {
                node.next.val +=value;
                node = node.next;
            }

            if (node.val >= 10) {
                node.val -= 10;
                node.next = new ListNode(1);
            }
        }

        return root;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode root = null, node = null;
        boolean moreThen10 = false;

        while (l1 != null || l2 != null || moreThen10) {
            int value = 0;

            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }

            if (moreThen10) {
                value++;
            }

            if (value >= 10) {
                value -= 10;
                moreThen10 = true;
            } else {
                moreThen10 = false;
            }

            if (root == null) {
                root = new ListNode(value);
                node = root;
            } else {
                node.next = new ListNode(value);
                node = node.next;
            }
        }

        return root;
    }
}
