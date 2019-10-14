package tree.level2;

import tree.TreeNode;

public class A04connect {
    public static void main(String[] args) {

    }

    public TreeNode connect(TreeNode root) {
        if(root == null){
            return null;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.next != null && root.right != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);

        return root;
    }
}
