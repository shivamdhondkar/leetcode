import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] arr, int target) {
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
