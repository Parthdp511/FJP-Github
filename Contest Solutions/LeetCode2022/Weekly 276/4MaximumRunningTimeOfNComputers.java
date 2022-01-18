class Solution {
    
    public boolean isPossible(int[] batteries, int n, long mid){
        long Sum = 0;
        for(int i=0; i<batteries.length; i++){
            if(batteries[i] < mid)  Sum += batteries[i];
            else                    Sum += mid;
        }
        return mid * n <= Sum;
    }
    
    public long maxRunTime(int n, int[] batteries) {
        long start = 0, end = 0, ans = 0;
        for(int power : batteries)  end += power;
        long sum = end;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(isPossible(batteries, n, mid)){
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return ans;
    }
}