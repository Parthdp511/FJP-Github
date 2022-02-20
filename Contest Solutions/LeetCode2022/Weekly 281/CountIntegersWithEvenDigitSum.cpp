class Solution {
public:
    
    int DigitCount(int n){
        int ans = 0;
        while(n){
            ans += n%10;
            n/=10;
        }
        return ans;
    }
    
    int countEven(int num) {
        int ans = 0;
        for(int i=1; i<=num; i++){
            if(DigitCount(i)%2 == 0)
                ans++;
        }
        return ans;
    }
};