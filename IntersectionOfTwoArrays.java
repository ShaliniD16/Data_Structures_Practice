class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> li = new ArrayList<>();
        for(int num:nums1){
            hm.put(num,hm.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            if(hm.containsKey(num)){
                if(!li.contains(num))
                li.add(num);
                hm.put(num,hm.get(num)-1);
                if(hm.get(num)==0) hm.remove(num);
            }
        }
        int[] res = new int[li.size()];
        for(int i = 0;i<li.size();i++){
            res[i] = li.get(i);
        }
        return res;

    }
}
