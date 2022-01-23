#include<bits/stdc++.h>
using namespace std;


class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        if(k <= 1)  return 0;
        int left = 0, right = 0, prod = 1, count = 0;
        while(right < nums.size()){
            prod *= nums[right];
            right++;
            while(left <= right && prod >= k){
                prod /= nums[left];
                left++;
            }
            count += (right - left);
        }
        return count;
    }
};