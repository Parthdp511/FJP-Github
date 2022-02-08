class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        k = nums.length - k;
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0; i<nums.length; i++){
            while(k > 0 && q.size() > 0 && q.getLast() > nums[i]){
                q.removeLast();
                k--;
            }
            q.addLast(nums[i]);
        }
        while(k-- > 0)  q.removeLast();
        int[] arr = new int[q.size()];
        int i = 0;
        while(q.size() > 0){
            arr[i++] = q.removeFirst();
        }
        return arr;
    }
}