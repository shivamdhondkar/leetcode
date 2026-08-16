class Solution {
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int[] leftsum = new int[n];
        int[] rightsum = new int[n];

        leftsum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftsum[i] = leftsum[i-1]+arr[i];
        }

        rightsum[n-1] = arr[n-1];
        for(int i = n-2; i>=0; i--){
            rightsum[i] = rightsum[i+1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            if(leftsum[i] == rightsum[i]){
                return i;
            }
        }
        return -1;
    }
}