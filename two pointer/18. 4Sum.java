/*
    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [], target = 0
Output: []
*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List <List<Integer>> ans = new ArrayList<>();
        if(nums.length < 4) return ans;
        Arrays.sort(nums);
        
        for(int i = 0 ; i < nums.length - 3 ; i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i +1 ; j < nums.length - 2 ; j++){
                if(j  > i +1 && nums[j] == nums[j-1])
                    continue;
                int lastOne = nums.length - 1;
                int firstOne = j + 1;
                
                while(firstOne < lastOne){
                    int sum = nums[i] + nums[j] + nums[lastOne] + nums[firstOne];
                    if(sum < target){
                        firstOne++;
                    }else if(sum > target){
                        lastOne--;
                    }else{
                        ans.add(Arrays.asList(nums[i],nums[j],nums[lastOne],nums[firstOne]));
                        firstOne++;
                        lastOne--;
                        while(nums[firstOne] == nums[firstOne-1] && firstOne < lastOne){
                            firstOne++;
                        }
                        while(nums[lastOne] == nums[lastOne+1] && firstOne < lastOne){
                            lastOne--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}