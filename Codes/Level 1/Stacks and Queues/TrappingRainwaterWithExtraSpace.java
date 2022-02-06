class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        for(int i=1; i<n; i++)
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        for(int i=n-2; i>=0; i--)
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        
        int ans = 0;
        for(int i=1; i<n-1; i++){
            int currWater = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(currWater < 0)   currWater = 0;
            ans += currWater;
        }
        return ans;
    }
}