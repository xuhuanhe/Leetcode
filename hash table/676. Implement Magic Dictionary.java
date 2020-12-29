class MagicDictionary {

    /** Initialize your data structure here. */
    Map<String, List<int []>> map;
    public MagicDictionary() {
        map = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for(String each : dictionary){
            String sub = "";
            for(int i = 0 ; i < each.length() ; i++){
                sub = each.substring(0,i) + each.substring(i+1);
                int[] pair = new int[]{i,each.charAt(i)};
                List <int[]> val = map.getOrDefault(sub, new ArrayList<>());
                val.add(pair);
                map.put(sub,val);
            }
        }
    }
    
    public boolean search(String word) {
        for(int i = 0 ; i < word.length() ; i++){
            String sub = word.substring(0,i) + word.substring(i+1);
            if(map.containsKey(sub)){
                for(int pair[] : map.get(sub)){
                    if(pair[0] == i && pair[1] != word.charAt(i))
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */