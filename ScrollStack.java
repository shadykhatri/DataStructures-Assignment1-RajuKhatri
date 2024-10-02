import java.util.Stack;

public class ScrollStack {

    // Stack to store the scrolls
    private Stack<String> scrollStack;

    // Constructor
    public ScrollStack() {
        scrollStack = new Stack<>();
    }

    // Push a new scroll onto the stack
    public void pushScroll(String scrollTitle) {
        scrollStack.push(scrollTitle);
        System.out.println("Pushed scroll: " + scrollTitle);
    }

    // Pop the top scroll off the stack
    public String popScroll() {
        if (scrollStack.isEmpty()) {
            System.out.println("No scrolls to pop.");
            return null;
        }
        String poppedScroll = scrollStack.pop();
        System.out.println("Popped scroll: " + poppedScroll);
        return poppedScroll;
    }

    // Peek at the top scroll without removing it
    public String peekScroll() {
        if (scrollStack.isEmpty()) {
            System.out.println("No scrolls to peek.");
            return null;
        }
        String topScroll = scrollStack.peek();
        System.out.println("Top scroll: " + topScroll);
        return topScroll;
    }

    // Check if a specific scroll title exists in the stack
    public boolean containsScroll(String scrollTitle) {
        boolean contains = scrollStack.contains(scrollTitle);
        if (contains) {
            System.out.println("The scroll '" + scrollTitle + "' exists in the stack.");
        } else {
            System.out.println("The scroll '" + scrollTitle + "' does not exist in the stack.");
        }
        return contains;
    }

    public static void main(String[] args) {
        // Create a new ScrollStack
        ScrollStack stack = new ScrollStack();
        
        // Push scrolls onto the stack
        stack.pushScroll("Ancient Scroll of Wisdom");
        stack.pushScroll("Scroll of Fire Spells");
        stack.pushScroll("Scroll of Water Magic");

        // Peek at the top scroll
        stack.peekScroll();

        // Pop the top scroll off
        stack.popScroll();

        // Check if a specific scroll exists
        stack.containsScroll("Scroll of Fire Spells");
        stack.containsScroll("Ancient Scroll of Light");

        // Peek at the top scroll after popping
        stack.peekScroll();
    }
}
