class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, ans = 0, leftMax = 0, rightMax = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] < leftMax) ans += leftMax - height[left];
                else                        leftMax = height[left];
                left++;
            }else{
                if(height[right] < rightMax) ans += rightMax - height[right];
                else                         rightMax = height[right];
                right--;
            }
        }
        return ans;
    }
}