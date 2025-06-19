class MyCircularQueue {
    int[] queue;
    private int capacity;
    int head;
    int count;

    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
        head = 0;
        
        count = 0;
    }
    
    public boolean enQueue(int value) {
        if(capacity==count) return false;
        int index = (head+count)%capacity;
        queue[index] = value;
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0) return false;
        head = (head+1)%capacity;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0) return -1;
        return queue[head];
    }
    
    public int Rear() {
        if(count==0) return -1;
        return queue[(head+count-1)%capacity];
    }
    
    public boolean isEmpty() {
        if(count==0) 
            return true;
        return false;
    }
    
    public boolean isFull() {
        if(count==capacity) return true;
        return false;
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
