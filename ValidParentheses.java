class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
                
            }
            else{
                if(!stack.isEmpty()){
                    if(c==')' && stack.peek()!='(') return false;
                    else if(c==']' && stack.peek()!='[') return false;
                    else if(c=='}' && stack.peek()!='{') return false;
                    stack.pop();
                }
                else return false;
            }
            
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
