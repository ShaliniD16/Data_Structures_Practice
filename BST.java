import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class BST {
    TreeNode head;

    TreeNode add(TreeNode node, int num) {
        if (node == null) return new TreeNode(num);

        if (num < node.val)
            node.left = add(node.left, num);
        else if (num > node.val)
            node.right = add(node.right, num);

        return node;
    }

    boolean find(TreeNode node, int num) {
        if (node == null) return false;
        if (num == node.val) return true;
        return num < node.val ? find(node.left, num) : find(node.right, num);
    }

    TreeNode remove(TreeNode node, int num) {
        if (node == null) return null;

        if (num < node.val)
            node.left = remove(node.left, num);
        else if (num > node.val)
            node.right = remove(node.right, num);
        else {
            if (node.left == null)
                return node.right;
            if (node.right == null)
                return node.left;

            node.val = findMin(node.right);
            node.right = remove(node.right, node.val);
        }

        return node;
    }

    int findMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.val;
    }

    void printIn(TreeNode node) {
        if (node != null) {
            printIn(node.left);
            System.out.print(node.val + " ");
            printIn(node.right);
        }
    }

    void printPre(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            printPre(node.left);
            printPre(node.right);
        }
    }

    void printPost(TreeNode node) {
        if (node != null) {
            printPost(node.left);
            printPost(node.right);
            System.out.print(node.val + " ");
        }
    }

    void printLevel(TreeNode node) {
        if (node == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();

        int[] nums = {50, 30, 70, 20, 40, 60, 80};
        for (int n : nums)
            bst.head = bst.add(bst.head, n);

        System.out.print("Inorder: ");
        bst.printIn(bst.head);
        System.out.print("\nPreorder: ");
        bst.printPre(bst.head);
        System.out.print("\nPostorder: ");
        bst.printPost(bst.head);
        System.out.print("\nLevel Order: ");
        bst.printLevel(bst.head);

        int toFind = 40;
        System.out.print("\n\nSearching " + toFind + ": ");
        System.out.println(bst.find(bst.head, toFind) ? "Found" : "Not Found");

        int toRemove = 70;
        System.out.println("Removing " + toRemove);
        bst.head = bst.remove(bst.head, toRemove);

        System.out.print("Inorder after removal: ");
        bst.printIn(bst.head);
    }
}
