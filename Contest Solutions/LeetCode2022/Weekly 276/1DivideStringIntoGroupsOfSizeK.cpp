class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        vector<string> ans;
        string curr;
        int count = 0, n = s.size();
        for(int i=0; i<n; i++){
            count++;
            curr+=s[i];
            if(count == k){
                if(curr.size() == k){
                    ans.push_back(curr);
                }else{
                    while(curr.size() != k){
                        curr+=fill;
                        ans.push_back(curr);
                    }
                }
                curr = "";
                count = 0;
            }
        }
        if(count != 0 && count != k){
            while(curr.size() != k){
                curr+=fill;
            }
            ans.push_back(curr);
        }
        return ans;
    }
};