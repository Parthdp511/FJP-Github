class Solution {
public:
    vector<long long> maximumEvenSplit(long long n) {
        long long i = 2;
        vector<long long> ans;
        while(i <= n){
            if(n > 2 * i){
                ans.push_back(i);
                n -= i;
                i += 2;
            }else{
                if(n%2) return {};
                ans.push_back(n);
                break;
            }
        }
        if(n%2 == 0)    return ans;
        return {};
    }
};