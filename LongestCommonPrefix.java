class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        int minL = Integer.MAX_VALUE;
        for(String str:strs){
            if(str.length()<minL) minL = str.length();
        }
        boolean flag = true;
        for(int i = 0;i<minL;i++){
            for(int j = 0;j<strs.length-1;j++){
                if(!(strs[j].charAt(i)==strs[j+1].charAt(i))){
                    flag=false;
                    
                }
            }
            if(flag) res+=strs[0].charAt(i);
            else break;
        }
        return res;
    }
}
