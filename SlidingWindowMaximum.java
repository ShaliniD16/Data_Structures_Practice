class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0;i<nums.length;i++){
            while(!q.isEmpty() && q.peek()<=i-k){
                q.poll();
            }
            
            while(!q.isEmpty()&&nums[q.peekLast()]<=nums[i]){
                q.pollLast();
            }
            q.offer(i);
                
            
            if(i>=k-1) res.add(nums[q.peek()]);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
