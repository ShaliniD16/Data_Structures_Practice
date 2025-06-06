class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);

        }
        
        int len = nums.length/2;
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            if(entry.getValue()>len) return entry.getKey();
        }
        return 0;
    }
}
