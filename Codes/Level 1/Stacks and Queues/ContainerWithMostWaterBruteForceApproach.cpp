class Solution {
    public:
        int maxArea(vector<int>& height) {
            int n = height.size(), ans = 0;
            for(int i=0; i<n; i++){
                int currVol = 0;
                for(int j=i+1; j<n; j++){
                    currVol = max(currVol, min(height[i], height[j]) * (j - i));
                }
                ans = max(ans, currVol);
            }
            return ans;
        }
    };