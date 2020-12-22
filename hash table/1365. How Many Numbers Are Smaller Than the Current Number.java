class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //  0 1 2 3 4 5 6 8
        //  0 0 0 0 1 1 1 1
        //  0 0 0 0 0 1 2 3
        int count[] = new int[101];
        int sum[] = new int[101];
        for(int i = 0 ; i < nums.length; i++){
            count[nums[i]]++;
        }
        for(int i =1 ; i < 101 ; i++){
            sum[i] = count[i-1] + sum[i-1];
        }
        for(int i = 0 ; i < nums.length; i++){
            nums[i] = sum[nums[i]];
            
        }
        return nums;  
    }
}