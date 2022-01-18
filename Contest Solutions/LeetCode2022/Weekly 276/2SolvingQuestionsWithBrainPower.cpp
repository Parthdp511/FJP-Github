class Solution {
public:
    
    long long knapsack(int idx, vector<vector<int>> &questions, vector<long long> &dp){
        if(idx >= questions.size()){
            return 0;
        }
        
        if(dp[idx] != -1)
            return dp[idx];
        
        long long op1 = knapsack(idx + questions[idx][1] + 1, questions, dp) + questions[idx][0];
        long long op2 = knapsack(idx + 1, questions, dp) + 0;
        
        return dp[idx] = max(op1, op2);
    }
    
    long long mostPoints(vector<vector<int>>& questions) {
        vector<long long> dp(questions.size(), -1);
        return knapsack(0, questions, dp);
    }
};