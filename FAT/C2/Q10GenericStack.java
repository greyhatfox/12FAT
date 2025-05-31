package C2;

public class Q10GenericStack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] elements;
    private int top;

    // Constructor to initialize the stack with default capacity
    @SuppressWarnings("unchecked")
    public Q10GenericStack() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    // Constructor with custom initial capacity
    @SuppressWarnings("unchecked")
    public Q10GenericStack(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be positive");
        }
        elements = (T[]) new Object[initialCapacity];
        top = -1;
    }

    // Push method to add an item to the stack
    public void push(T item) {
        if (top == elements.length - 1) {
            resize();
        }
        elements[++top] = item;
    }

    // Pop method to remove and return the top item
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = elements[top];
        elements[top--] = null; // Clear the reference
        return item;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Return the current size of the stack
    public int size() {
        return top + 1;
    }

    // Helper method to resize the array when full
    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = elements.length * 2;
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    // Optional: Peek method to view the top item without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements[top];
    }

    public static void main(String[] args) {
        // Test with Integer type
        Q10GenericStack<Integer> intStack = new Q10GenericStack<>();
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        System.out.println("Integer Stack:");
        System.out.println("Size: " + intStack.size());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Pop: " + intStack.pop());
        System.out.println("Size after pops: " + intStack.size());

        // Test with Double type
        Q10GenericStack<Double> doubleStack = new Q10GenericStack<>(5);
        doubleStack.push(3.14);
        doubleStack.push(2.718);
        System.out.println("\nDouble Stack:");
        System.out.println("Size: " + doubleStack.size());
        System.out.println("Peek: " + doubleStack.peek());
        System.out.println("Pop: " + doubleStack.pop());
        System.out.println("Is empty? " + doubleStack.isEmpty());

        // Test with String type
        Q10GenericStack<String> stringStack = new Q10GenericStack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println("\nString Stack:");
        System.out.println("Size: " + stringStack.size());
        System.out.println("Pop: " + stringStack.pop());
        System.out.println("Pop: " + stringStack.pop());
        System.out.println("Is empty? " + stringStack.isEmpty());
    }
}