class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, MaxVol = 0;
        while(left <= right){
            MaxVol = Math.max(MaxVol, Math.min(height[left], height[right]) * (right - left));
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return MaxVol;
    }
}