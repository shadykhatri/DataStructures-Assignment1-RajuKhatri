public class ExplorerQueue {
    private String[] queue;
    private int front; // Points to the first explorer in the queue
    private int rear;  // Points to the last explorer in the queue
    private int size;  // Current number of explorers in the queue
    private int capacity; // Maximum number of explorers the queue can hold

    // Constructor to initialize the queue with a specified capacity
    public ExplorerQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue a new explorer to the queue
    public void enqueue(String explorer) {
        if (isFull()) {
            System.out.println("Queue is full! Cannot add more explorers.");
            return;
        }
        // Circular increment of the rear index
        rear = (rear + 1) % capacity;
        queue[rear] = explorer;
        size++;
        System.out.println(explorer + " has been added to the queue.");
    }

    // Dequeue an explorer when they enter the temple
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No explorers to dequeue.");
            return null;
        }
        String dequeuedExplorer = queue[front];
        // Circular increment of the front index
        front = (front + 1) % capacity;
        size--;
        System.out.println(dequeuedExplorer + " has entered the temple.");
        return dequeuedExplorer;
    }

    // Display the next explorer in line without dequeuing them
    public String peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty! No explorers in line.");
            return null;
        }
        System.out.println("Next explorer in line: " + queue[front]);
        return queue[front];
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        // Create an ExplorerQueue with a capacity of 3
        ExplorerQueue explorerQueue = new ExplorerQueue(3);

        // Add explorers to the queue
        explorerQueue.enqueue("Explorer A");
        explorerQueue.enqueue("Explorer B");
        explorerQueue.enqueue("Explorer C");

        // Try to enqueue when the queue is full
        explorerQueue.enqueue("Explorer D");

        // Peek the next explorer in line
        explorerQueue.peek();

        // Dequeue explorers as they enter the temple
        explorerQueue.dequeue();
        explorerQueue.dequeue();

        // Add another explorer after dequeuing
        explorerQueue.enqueue("Explorer D");

        // Check the next explorer in line
        explorerQueue.peek();
        
        // Dequeue remaining explorers
        explorerQueue.dequeue();
        explorerQueue.dequeue();

        // Try to dequeue when the queue is empty
        explorerQueue.dequeue();
    }
}
