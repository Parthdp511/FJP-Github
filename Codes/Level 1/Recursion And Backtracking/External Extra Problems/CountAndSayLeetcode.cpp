class Solution {
public:
    string countAndSay(int n) {
        if(n == 1)  return "1";
        string curr = countAndSay(n-1);
        string ans = "";
        for(int i=0; i<curr.size(); i++){
            int count = 1;
            while(i < curr.size() - 1 && curr[i+1] == curr[i]){
                i++;
                count++;
            }
            ans += to_string(count) + curr[i];
        }
        return ans;
    }
};