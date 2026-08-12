class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> feq = new HashMap<>() ;

        for(int i: nums){
            feq.put(i, feq.getOrDefault(i, 0)+1);
        }

        for (int i : nums) {
            if(feq.get(i)>1){
                return i;
            }
        }
        return -1;
        
        // int n = nums.length;

        // for(int i=0; i<n-1;i++){
        //     for(int j=i+2; j<n;j++){
        //         if(nums[i] == nums[j]){
        //             return nums[i];
        //         }
        //     }
        // }
        // return -1;
    }
}