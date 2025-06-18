class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();

    }
    
    public void push(int x) {
        q1.offer(x);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
        Queue temp = q1;
        q1 = q2;
        q2 = temp;

    }
    
    public int pop() {
        if(!q2.isEmpty()){
            return q2.poll();
        }
        else return -1;
        
    }
    
    public int top() {
        return q2.peek();
    }
    
    public boolean empty() {
        if(q2.isEmpty()) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
