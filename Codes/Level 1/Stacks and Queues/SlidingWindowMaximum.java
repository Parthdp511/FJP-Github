class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        int idx = 0;
        for(int i=0; i<nums.length; i++){
            
            // remove first -> when front element is excluded from current window
            if(q.size() > 0 && q.getFirst() <= i - k)   q.removeFirst();
            
            // remove last -> elements which are smaller than current element
            while(q.size() > 0 && nums[q.getLast()] < nums[i])
                q.removeLast();
            
            // addLast -> current element can be the answer of current or upcoming windows
            q.addLast(i);
            
            if(i >= k - 1){
                // current window's maximum is at front
                res[idx++] = nums[q.getFirst()];
            }
        }
        return res;
    }
}