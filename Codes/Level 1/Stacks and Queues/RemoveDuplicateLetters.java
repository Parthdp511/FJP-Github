class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<Character> q = new ArrayDeque<>();
        
        int[] freq = new int[26];
        boolean[] inQueue = new boolean[26];
        
        for(int i=0; i<s.length(); i++)
            freq[s.charAt(i) - 'a']++;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq[ch - 'a']--;
            if(inQueue[ch - 'a'] == true)
                continue;
            
            while(q.size() > 0 && q.getLast() > ch && freq[q.getLast() - 'a'] > 0){
                inQueue[q.removeLast() - 'a'] = false;
            }
            q.addLast(ch);
            inQueue[ch - 'a'] = true;
        }
        
        StringBuilder str = new StringBuilder("");
        while(q.size() > 0)
            str.append(q.removeFirst());
        return str.toString();
    }
}