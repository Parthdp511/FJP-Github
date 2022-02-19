class Solution {
public:
    vector<long long> sumOfThree(long long num) {
        if(num%3 != 0)  return {};
        int k = num/3;
        return {num/3 - 1, num/3, num/3 + 1};
    }
};