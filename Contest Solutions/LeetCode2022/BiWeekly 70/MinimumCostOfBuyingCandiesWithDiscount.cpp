class Solution {
public:
    int minimumCost(vector<int>& cost) {
        int n = cost.size();
        int sum = 0;
        sort(cost.begin(), cost.end(), greater<int>());
        for(int i=0; i<n; i++)  sum += cost[i];
        if(n <= 3){
            if(n <= 2)  return sum;
            else    return sum - cost[2];
        }
        int ans = 0;
        for(int i=0; i<n; i++){
            if(i%3 != 2)
                ans += cost[i];
        }
        return ans;
    }
};