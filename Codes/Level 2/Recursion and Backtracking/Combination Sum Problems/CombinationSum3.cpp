class Solution {
public:
    
    
    void combine(vector<vector<int>> &ans, vector<int> currAns, vector<bool> visited, 
                 int k, int n, int Chosen, int currSum, int currNum){
        if(Chosen == k){
            if(currSum == n){
                ans.push_back(currAns);
            }
            return;
        }
        
        for(int i=currNum + 1; i<=9; i++){
            if(visited[i] == false && currSum + i <= n){
                currAns.push_back(i);
                visited[i] = true;
                combine(ans, currAns, visited, k, n, Chosen + 1, currSum + i, i);
                visited[i] = false;
                currAns.pop_back();
            }
        }
    }
    
    vector<vector<int>> combinationSum3(int k, int n) {
        vector<vector<int>> ans;
        vector<int> currAns;
        vector<bool> visited(10, false);
        combine(ans, currAns, visited, k, n, 0, 0, 0);
        return ans;
    }
};