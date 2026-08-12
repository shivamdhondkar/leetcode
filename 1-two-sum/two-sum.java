import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] arr, int target) {

        // Map<Integer, Integer> map = new HashMap<>();
        
        // for (int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
          
        //     if (map.containsKey(complement)) {
        //         return new int[] { map.get(complement), i };
        //     }
            
        //     map.put(nums[i], i);
        // }
        
        // return new int[] {};
        int n = arr.length;
        
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] ==target){
                    int[] ans = {i,j};
                    return ans;
                }
                
            }
            
        }
        int[] ans = {};
        return ans;
    }
}
