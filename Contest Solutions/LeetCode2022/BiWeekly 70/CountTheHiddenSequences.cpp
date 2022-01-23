class Solution {
public:
    int numberOfArrays(vector<int>& differences, int lower, int upper) {
       long count = 0, minVal = 0, maxVal = 0;
        for(int i=0; i<differences.size(); i++){
            count += (differences[i]);
            minVal = min(minVal, count);
            maxVal = max(maxVal, count);
        }
        int ans = upper - lower - maxVal + minVal + 1;
        return ans > 0 ? ans : 0;
    }
};