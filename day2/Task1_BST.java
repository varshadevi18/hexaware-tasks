public class Task1_BST {

    static class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
        }
    }

    static Node insert(Node root, String value) {

        if (root == null) {
            return new Node(value);
        }

        if (value.compareTo(root.data) < 0) {
            root.left = insert(root.left, value);
        } else if (value.compareTo(root.data) > 0) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    static boolean search(Node root, String key) {

        if (root == null) {
            return false;
        }

        if (root.data.equals(key)) {
            return true;
        }

        if (key.compareTo(root.data) < 0) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    static void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {

        Node root = null;

        String[] categories = {
            "Electronics", "Clothing", "Books",
            "Furniture", "Groceries", "Mobiles",
            "Laptops", "Shoes", "Watches",
            "Sports", "Beauty", "Toys",
            "Kitchen", "Accessories", "Gaming"
        };

        for (String category : categories) {
            root = insert(root, category);
        }

        System.out.println("15 Categories inserted.");

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.println("\nSearch Mobiles: "
                + search(root, "Mobiles"));

        System.out.println("Search Fashion: "
                + search(root, "Fashion"));
    }
}