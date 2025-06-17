import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value;
    Node left, right;

    public Node(int val) {
        value = val;
        left = right = null;
    }
}

public class Tree {
    Node root;

    void showPre(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        showPre(node.left);
        showPre(node.right);
    }

    void showIn(Node node) {
        if (node == null) return;
        showIn(node.left);
        System.out.print(node.value + " ");
        showIn(node.right);
    }

    void showPost(Node node) {
        if (node == null) return;
        showPost(node.left);
        showPost(node.right);
        System.out.print(node.value + " ");
    }

    void remove(int val) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.value == val) root = null;
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node toDelete = null, last = null;

        while (!q.isEmpty()) {
            last = q.poll();
            if (last.value == val)
                toDelete = last;
            if (last.left != null)
                q.add(last.left);
            if (last.right != null)
                q.add(last.right);
        }

        if (toDelete != null) {
            int lastVal = last.value;
            deleteLast(last);
            toDelete.value = lastVal;
        }
    }

    void deleteLast(Node del) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.left != null) {
                if (cur.left == del) {
                    cur.left = null;
                    return;
                } else {
                    q.add(cur.left);
                }
            }

            if (cur.right != null) {
                if (cur.right == del) {
                    cur.right = null;
                    return;
                } else {
                    q.add(cur.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);

        System.out.print("Inorder before: ");
        t.showIn(t.root);
        System.out.println();

        t.remove(3); 

        System.out.print("Inorder after: ");
        t.showIn(t.root);
        System.out.println();
    }
}
