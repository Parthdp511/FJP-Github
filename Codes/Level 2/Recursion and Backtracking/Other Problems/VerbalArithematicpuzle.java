class Solution {
    public boolean isSolvable(String[] words, String result) {
        String unique = generateUniqueWord(words, result);
        int[] charMap = new int[26];
        Arrays.fill(charMap, -1);
        boolean[] flagTr = new boolean[26];
        for(String word: words)
            if(word.length() > 1) flagTr[word.charAt(0) - 'A'] = true;
        if(result.length() > 1) flagTr[result.charAt(0) - 'A'] = true;    
        return helper(unique, 0, words, result, new boolean[10], charMap, flagTr);
    }
    
    private boolean helper(String unique, int idx, String[] words, String result, boolean[] usedNum, int[] charMap, boolean[] flag){
        if(idx >= unique.length()){
            int sum = 0;
            for(String word: words) sum += generateNumber(word, charMap);
            if(sum == generateNumber(result, charMap)) return true;
            else return false;
        }
        char ch = unique.charAt(idx);
        for(int i = 0; i <= 9; i++){
            if(i == 0 && flag[ch - 'A']) continue;
            if(!usedNum[i]){
                usedNum[i] = true;
                charMap[ch - 'A'] = i;
                boolean res = helper(unique, idx + 1, words, result, usedNum, charMap, flag);
                if(res) return res;
                usedNum[i] = false;
                charMap[ch - 'A'] = -1;
            }
        }
        return false;
    }
    
    private int generateNumber(String word, int[] charMap){
        int number = 0;
        for(char ch: word.toCharArray()) number = number * 10 + charMap[ch - 'A'];
        return number;
    }
    
    private String generateUniqueWord(String[] words, String result){
        StringBuilder sb = new StringBuilder();
        boolean[] map = new boolean[26];
        for(String word: words)
            for(char ch: word.toCharArray())
                map[ch - 'A'] = true;
        for(char ch: result.toCharArray())
            map[ch - 'A'] = true;
        for(int i = 0; i < 26; i++)
            if(map[i]) sb.append((char)(i + 'A'));
        return sb.toString();
    }
}