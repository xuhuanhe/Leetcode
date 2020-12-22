class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for( int a :arr){
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        for( int each: map.values()){
            if(set.contains(each)){
                return false;
            }else{
                set.add(each);
            }
        }
        return true;
    }
}