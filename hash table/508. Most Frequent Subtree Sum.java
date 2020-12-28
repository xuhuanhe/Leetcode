/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int max = -1;
        dfs(root,map);
        for(int val : map.values()){
            max = Math.max(val,max);
        }
        for(int key: map.keySet()){
            if(map.get(key) == max){
                list.add(key);
            }
        }
        int ans[] = new int[list.size()];
        int i = 0;
        for(int num : list){
            ans[i] = num;
            i++;
        }
        return ans;
        
    }
    public int dfs(TreeNode node, Map<Integer,Integer> map){
        if(node == null) return 0;
        int left = dfs(node.left,map);
        int right = dfs(node.right,map);
        int sum = node.val + left + right;
        map.put(sum,map.getOrDefault(sum,0)  +1 );
        return sum;
    }
}