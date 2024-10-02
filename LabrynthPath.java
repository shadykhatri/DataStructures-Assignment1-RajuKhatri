class LabyrinthPath {

    // Node class to represent each location in the path
    private static class Node {
        String location;
        Node next;

        public Node(String location) {
            this.location = location;
            this.next = null;
        }
    }

    private Node head;  // Start of the path
    private Node tail;  // End of the path

    public LabyrinthPath() {
        head = null;
        tail = null;
    }

    // Add a new location to the path
    public void addLocation(String location) {
        Node newNode = new Node(location);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove the last visited location
    public void removeLastLocation() {
        if (head == null) {
            System.out.println("No locations to remove.");
            return;
        }
        if (head == tail) {  // If there's only one node
            head = null;
            tail = null;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
    }

    // Check if the path contains a loop (trap)
    public boolean containsLoop() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true; // Loop detected
            }
        }
        return false;
    }

    // Print the entire path
    public void printPath() {
        if (head == null) {
            System.out.println("Path is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.location + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LabyrinthPath path = new LabyrinthPath();
        
        path.addLocation("Entrance");
        path.addLocation("Hallway");
        path.addLocation("Chamber");
        path.addLocation("Dead End");

        System.out.println("Current Path:");
        path.printPath();

        path.removeLastLocation();
        System.out.println("After removing last location:");
        path.printPath();

        // Create a loop manually for testing
        Node loopNode = path.head.next; // "Hallway"
        path.tail.next = loopNode;       // Make "Dead End" point to "Hallway"

        System.out.println("Contains loop: " + path.containsLoop());
    }
}
