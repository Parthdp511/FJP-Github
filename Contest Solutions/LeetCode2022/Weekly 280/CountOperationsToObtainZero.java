class Solution {
    public int countOperations(int num1, int num2) {
        int ans = 0, a = num1, b = num2;
        while(num1 != 0 && num2 != 0){
            if(num1 >= num2){
                a = num1 - num2;
            }else{
                b = num2 - num1;
            }
            num1 = a;
            num2 = b;
            ans++;
        }
        return ans;
    }
}