public class RequestQueue {// Custom array based queue implementation
    private char[] queue;
    private int front;
    private int rear;
    private int size;
    public RequestQueue(int capacity) {
        queue = new char[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    public void enqueue(char c) {
        rear++;
        queue[rear] = c;
        size++;
    }
    public char dequeue() {
        char value = queue[front];
        front++;
        size--;
        return value;
    }
    public boolean isEmpty() {
        return size == 0;
    }
}
