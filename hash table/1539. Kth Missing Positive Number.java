class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for(int each: arr){
            set.add(each);
        }
        int count = 0;
        int eachNumberFrom1 = 1;

        while(true){
            if(set.contains(eachNumberFrom1)){
                eachNumberFrom1++;
            }else{
                eachNumberFrom1++;
                count++;
                if(count == k)
                    return eachNumberFrom1-1;
            }
        }
    }
}