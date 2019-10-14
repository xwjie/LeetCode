package tree.level2;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class A05kthSmallest {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);

        head.left = node1;
        head.right = node4;
        node1.right = node2;

        System.out.println(kthSmallest(head, 2));
    }

    static void walkTree(TreeNode node, List<Integer> values) {
        if (node.left != null) {
            walkTree(node.left, values);
        }

        values.add(node.val);

        if (node.right != null) {
            walkTree(node.right, values);
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new LinkedList<>();

        walkTree(root, values);

        return values.get(k - 1);
    }
}
