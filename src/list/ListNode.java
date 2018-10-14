package list;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public static ListNode createList(int[] nums) {
        ListNode root = null, node = null;

        for (int i = 0; i < nums.length; i++) {
            if (root == null) {
                root = new ListNode(nums[i]);
                node = root;
            } else {
                node.next = new ListNode(nums[i]);
                node = node.next;
            }
        }

        return root;
    }

    public static void print(ListNode result) {
        if(result == null){
            return;
        }

        System.out.print(result.val);

        if(result.next != null){
            System.out.print("->");
            print(result.next);
        }
        else{
            System.out.println();
        }
    }
}