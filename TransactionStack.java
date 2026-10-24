public class TransactionStack {// Custom array based stack implementation
    private char[] stack;
    private int top;
    public TransactionStack(int size) {
        stack = new char[size];
        top = -1;// Inserts an element at the top of stack
    }
    public void push(char c) {
        stack[++top] = c;
    }
    public char pop() {// Removes and returns top element
        return stack[top--];
    }
    public char peek() {
        return stack[top];
    }
    public boolean isEmpty() {
        return top == -1;
    }
}
