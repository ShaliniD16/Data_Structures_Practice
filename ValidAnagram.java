class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> first = new HashMap<>();
        HashMap<Character, Integer> second = new HashMap<>();
        
        for(char c:s.toCharArray()){
            first.put(c,first.getOrDefault(c,0)+1);
        }
        for(char c:t.toCharArray()){
            second.put(c,second.getOrDefault(c,0)+1);
        
        }
        if(first.equals(second)) return true;
        return false;

    }
}
