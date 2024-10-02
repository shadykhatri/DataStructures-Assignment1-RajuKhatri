public class ClueTree {

    // Node class to represent each clue in the binary tree
    private static class Node {
        String clue;
        Node left, right;

        public Node(String clue) {
            this.clue = clue;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Constructor
    public ClueTree() {
        root = null;
    }

    // Insert a new clue into the tree
    public void insertClue(String clue) {
        root = insertRecursive(root, clue);
    }

    // Helper method for recursive insertion
    private Node insertRecursive(Node node, String clue) {
        if (node == null) {
            return new Node(clue);
        }

        // Insert clues alphabetically for this example (left is smaller, right is greater)
        if (clue.compareTo(node.clue) < 0) {
            node.left = insertRecursive(node.left, clue);
        } else if (clue.compareTo(node.clue) > 0) {
            node.right = insertRecursive(node.right, clue);
        }
        return node;
    }

    // In-order traversal (Left, Root, Right)
    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println();
    }

    private void inOrderRecursive(Node node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.clue + " ");
            inOrderRecursive(node.right);
        }
    }

    // Pre-order traversal (Root, Left, Right)
    public void preOrderTraversal() {
        preOrderRecursive(root);
        System.out.println();
    }

    private void preOrderRecursive(Node node) {
        if (node != null) {
            System.out.print(node.clue + " ");
            preOrderRecursive(node.left);
            preOrderRecursive(node.right);
        }
    }

    // Post-order traversal (Left, Right, Root)
    public void postOrderTraversal() {
        postOrderRecursive(root);
        System.out.println();
    }

    private void postOrderRecursive(Node node) {
        if (node != null) {
            postOrderRecursive(node.left);
            postOrderRecursive(node.right);
            System.out.print(node.clue + " ");
        }
    }

    // Find a specific clue in the tree
    public boolean findClue(String clue) {
        return findClueRecursive(root, clue);
    }

    private boolean findClueRecursive(Node node, String clue) {
        if (node == null) {
            return false;
        }

        if (clue.equals(node.clue)) {
            return true;
        }

        if (clue.compareTo(node.clue) < 0) {
            return findClueRecursive(node.left, clue);
        } else {
            return findClueRecursive(node.right, clue);
        }
    }

    // Count the total number of clues in the tree
    public int countClues() {
        return countCluesRecursive(root);
    }

    private int countCluesRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countCluesRecursive(node.left) + countCluesRecursive(node.right);
    }

    public static void main(String[] args) {
        ClueTree clueTree = new ClueTree();

        // Insert clues into the tree
        clueTree.insertClue("Key");
        clueTree.insertClue("Map");
        clueTree.insertClue("Compass");
        clueTree.insertClue("Lantern");
        clueTree.insertClue("Treasure");

        // Perform tree traversals
        System.out.println("In-order traversal:");
        clueTree.inOrderTraversal(); // Compass Key Lantern Map Treasure

        System.out.println("Pre-order traversal:");
        clueTree.preOrderTraversal(); // Key Compass Lantern Map Treasure

        System.out.println("Post-order traversal:");
        clueTree.postOrderTraversal(); // Compass Lantern Treasure Map Key

        // Find a specific clue
        System.out.println("Is 'Map' in the tree? " + clueTree.findClue("Map")); // true
        System.out.println("Is 'Sword' in the tree? " + clueTree.findClue("Sword")); // false

        // Count the total number of clues
        System.out.println("Total number of clues: " + clueTree.countClues()); // 5
    }
}
