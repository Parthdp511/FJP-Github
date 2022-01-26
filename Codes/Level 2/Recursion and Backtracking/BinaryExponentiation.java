class Solution {
    
    public double power(double x, int n){
        if(n == 0)
            return 1;
        
        double currAns = power(x, n/2);
        if(n%2 == 0)    currAns = currAns * currAns;
        else            currAns = currAns * currAns * x;
        return currAns;
    }
    
    public double myPow(double x, int n) {
        if(n < 0){
            double temp = power(x, -1 * n);
            return 1 / temp;
        }
        return power(x, n);
    }
}