class Solution {
public:
    
    void combine(vector<vector<int>> &ans, vector<int> &currAns, int currBox, int n, int k){
        if( currBox == n + 1 ){
            if(currAns.size() == k){
                vector<int> temp = currAns;
                ans.push_back(temp);
            }
            return;
        }
        
        // Call for 2 possible options for each box, 1. Include item on box,  2. Don't include item on box
        // The order could be reverse, making it easier. But In order to match the given answer, first call is for including and second if for not including
        
        if(currAns.size() < k){
            currAns.push_back(currBox);
        
            combine(ans, currAns, currBox + 1, n, k);
        
            currAns.pop_back();
        }
        
        combine(ans, currAns, currBox + 1, n, k);
    }
    
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;
        vector<int> currAns;
        
        combine(ans, currAns, 1, n, k);
        
        return ans;
    }
};