class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> q = new ArrayDeque<>();
        for(int i=0; i<num.length(); i++){
            char ch = num.charAt(i);
            while(k > 0 && q.size() > 0 && q.getLast() > ch){
                q.removeLast();
                k--;
            }
            q.addLast(ch);
        }
        while(k-- > 0){
            q.removeLast();
        }
        StringBuilder str = new StringBuilder("");
        while(q.size() > 0 && q.getFirst() == '0') q.removeFirst();
        while(q.size() > 0)
            str.append(q.removeFirst());
        return str.toString().length() == 0 ? "0" : str.toString();
    }
}