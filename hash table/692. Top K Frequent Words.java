class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String each : words){
            map.put(each, map.getOrDefault(each, 0) + 1);
        }
        PriorityQueue <String> queue = new PriorityQueue<>((String a, String b) -> {
                int aCount = map.get(a);
                int bCount = map.get(b);
            
                // If the counts are equal, then use String.compareTo to lexigraphically compare the strings
                if (aCount == bCount) {
                    return a.compareTo(b);
                } else {  // Else sort by greatest count
                    return bCount - aCount;
                }
            });
        
        queue.addAll(map.keySet());
        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < k ; i++){
            list.add(queue.poll());
        }
        return list;
    }
}