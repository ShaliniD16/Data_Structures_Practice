class MinStack {
    Stack<Long> s; 
    long minEle = Long.MAX_VALUE;
    
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        long value = (long) val;  
        
        if(s.isEmpty()){
            s.push(value);
            minEle = value;
        } else if(value >= minEle) {
            s.push(value);
        } else {
            long x = 2 * value - minEle;  
            minEle = value;
            s.push(x);
        }
    }
    
    public void pop() {
        if(s.isEmpty()) return;
        
        long y = s.pop();
        if(y < minEle){
            long x = minEle;
            minEle = 2 * x - y;  
        }
    }
    
    public int top() {
        long y = s.peek();
        if(y < minEle){
            return (int) minEle;  
        }
        return (int) y;  
    }
    
    public int getMin() {
        return (int) minEle;
    }
}
