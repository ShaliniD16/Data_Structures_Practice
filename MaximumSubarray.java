class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int global = nums[0];
        for(int i = 1;i<nums.length;i++){
            curr = Math.max(nums[i],nums[i]+curr);
            global = Math.max(global,curr);
        }
        return global;
    }
}
