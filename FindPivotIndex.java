class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        int ls = 0;
        for(int i =0;i<nums.length;i++){
            sum-=nums[i];
            if(sum==ls) return i;
            ls+=nums[i];
        }
        return -1;
    }
}
