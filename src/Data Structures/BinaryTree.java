public class BinaryTree {
    Node root;

    // Inserts a value into the BST
    public Node insert(Node current, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value > root.value) {
            root.right = insert(root.right, value);
        } else {
            root.left = insert(root.left, value);
        }

        return root;
    }

    // Calls the recursive insert method
    public void callInsert(int value) {
        root = insert(root, value);
    }

    // Searches if a value exists within the tree
    public Node search(Node current, int value) {
        if (root == null || root.value == value) {
            return root;
        }

        if(value > root.value) {
            return search(root.right, value);
        } else {
            return search(root.left, value);
        }
    }

    // Performs preorder traversal
    public void preorder(Node current) {
        if(current != null) {
            System.out.println(current.value);
            preorder(current.left);
            preorder(current.right);
        }
    }

    // Performs inorder traversal
    public void inorder(Node current) {
        if(current != null) {
            preorder(current.left);
            System.out.println(current.value);
            preorder(current.right);
        }
    }

    // Performs postorder traversal
    public void postorder(Node current) {
        if(current != null) {
            preorder(current.left);
            preorder(current.right);
            System.out.println(current.value);
        }
    }

}

// Node Class
class Node {
    int value;
    Node left, right;

    Node(int value) {
        left = right = null;
        this.value = value;
    }
}
