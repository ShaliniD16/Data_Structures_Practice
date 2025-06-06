class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,Comparator.comparingInt(a->a[0]));
        List<int[]> res = new ArrayList<>();
        int[] interval = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            int[] curr = intervals[i];
            if(interval[1]>=curr[0]) interval[1] = Math.max(interval[1],curr[1]);
            else{
                res.add(interval);
                interval = curr;
            }
        }
        res.add(interval);
        return res.toArray(new int[res.size()][]);
    }
}
