class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int move = 0;
        int count = 0;
        Set<Character> set = new HashSet<>();

        while(move<s.length()){
            if(!set.contains(s.charAt(move))){
                set.add(s.charAt(move));
                move++;
                count = Math.max(count,set.size());
            }else{
                set.remove(s.charAt(start));
                start++;
            }
        }
        return count;
    }
}