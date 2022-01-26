class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new ArrayDeque<>();
        for(int i=0; i<n; i++){
            q.add(i);
        }
        int count = 0;
        while(q.size() > 1){
            int val = q.remove();
            count++;
            if(count == k){
                count = 0;
            }else{
                q.add(val);
            }
        }
        return q.peek() + 1;
    }
}