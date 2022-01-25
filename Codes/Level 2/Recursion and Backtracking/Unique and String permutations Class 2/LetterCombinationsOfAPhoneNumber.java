class Solution {
    
    List<String> res;
    
    
    String[] keyPad = {"", "", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public void letterCombinations(int idx, String input, String output){
        if(idx == input.length()){
            res.add(output);
            return;
        }
        
        String word = keyPad[input.charAt(idx) - '0'];
        for(char letter : word.toCharArray()){
            letterCombinations(idx + 1, input, output + letter);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if(digits.length() == 0)    return res;
        letterCombinations(0, digits, "");
        return res;
    }
}   