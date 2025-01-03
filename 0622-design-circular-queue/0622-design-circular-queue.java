class MyCircularQueue {
    // Interface for storing elements
    private List<Integer> queue;
    // Unchanging size for the queue
    private int queueSize;
    // Counter for the number of elements
    private int numElements;
    // Pointers for elements in queue
    private int front_p, rear_p;

    public MyCircularQueue(int k) {
        queue = new ArrayList<Integer>(k);
        queueSize = k;
        numElements = 0;
        front_p = 0;
        rear_p = -1; // Start at -1 since it will be immediately incremented
    }
    
    // Return true if the element was added successfully
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear_p = (rear_p + 1) % queueSize;
            if (rear_p >= queue.size()) {
                queue.add(value);  // Add the new element
            }
            else {
                queue.set(rear_p, value);
            }
            
            numElements++;
            return true;
        }
        else return false;
    }
    
    // Return true if the element was removed successfully
    public boolean deQueue() {
        if (!isEmpty()) {
            front_p = (front_p + 1) % queueSize;
            numElements--;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (isEmpty()) return -1;

        return queue.get(front_p);
    }
    
    public int Rear() {
        if (isEmpty()) return -1;

        return queue.get(rear_p);
    }
    
    public boolean isEmpty() {
        return numElements == 0;
    }
    
    public boolean isFull() {
        return numElements == queueSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */