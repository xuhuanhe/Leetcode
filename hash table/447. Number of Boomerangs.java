// you are given n points in the plane that are all distinct, where points[i] = [xi, yi]. A boomerang is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

// Return the number of boomerangs.

 

// Example 1:

// Input: points = [[0,0],[1,0],[2,0]]
// Output: 2
// Explanation: The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]].
// Example 2:

// Input: points = [[1,1],[2,2],[3,3]]
// Output: 2
// Example 3:

// Input: points = [[1,1]]
// Output: 0
 

// Constraints:

// n == points.length
// 1 <= n <= 500
// points[i].length == 2
// -104 <= xi, yi <= 104
// All the points are unique.
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for( int i = 0 ; i < points.length ; i++){
            for( int j = 0 ; j < points.length ; j++){
                if(i == j ) 
                    continue;
                int distance = getDistance(points[i], points[j]);
                map.put(distance, map.getOrDefault(distance,0)+1);
                
            }
            for( int val : map.values()){
                ans += val *(val-1);
            }
            map.clear();
        }
        return ans;
    }
    public int getDistance(int point1[], int[] point2){
        int disx = point1[0] - point2[0];
	    int disy = point1[1] - point2[1];
	    return disx * disx + disy * disy;
    }
}