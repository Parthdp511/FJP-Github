class Solution{
    public int solve(int n, int k){
        if (n == 1)    return 0;
        return (solve(n - 1, k) + k) % n;
    }
    public int findTheWinner(int n, int k){
        return 1 + solve(n,k);// added one for converting in 1 based indexing
    }
};

