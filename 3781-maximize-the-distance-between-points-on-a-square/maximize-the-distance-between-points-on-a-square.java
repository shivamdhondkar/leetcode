import java.util.*;

class Solution {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] linearPoints = new long[n];
        
        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            if (y == 0) linearPoints[i] = x;
            else if (x == side) linearPoints[i] = (long) side + y;
            else if (y == side) linearPoints[i] = (long) 2 * side + (side - x);
            else linearPoints[i] = (long) 3 * side + (side - y);
        }
        
        Arrays.sort(linearPoints);
        
        int low = 1, high = side;
        int ans = 1;
        long totalPerimeter = 4L * side;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(linearPoints, k, mid, totalPerimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canPlace(long[] pts, int k, int minDist, long perimeter) {
        int n = pts.length;
        
        for (int i = 0; i < n; i++) {
            if (pts[i] > pts[0] + minDist) break; 
            
            int count = 1;
            long lastPos = pts[i];
            long firstPos = pts[i];
            int currIdx = i;
            
            for (int j = 1; j < k; j++) {
                long target = lastPos + minDist;
                int nextIdx = findNext(pts, target);
                if (nextIdx == -1 || nextIdx >= n + i) {
                    count = -1;
                    break;
                }
                
                long actualPos = (nextIdx < n) ? pts[nextIdx] : pts[nextIdx % n] + perimeter;
                lastPos = actualPos;
                count++;
            }
           
            if (count == k && (firstPos + perimeter - lastPos) >= minDist) {
                return true;
            }
        }
        return false;
    }
    
    private int findNext(long[] pts, long target) {
        int l = 0, r = pts.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (pts[mid] >= target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}