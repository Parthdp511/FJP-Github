class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int start = 0, end = numbers.size() - 1;
        while(start < end){
            int currSum = numbers[start] + numbers[end];
            if(currSum == target){
                return {start + 1, end + 1};
            }else if(currSum < target){
                start++;
            }else{
                end--;
            }
        }
        return {-1, -1};
    }
};