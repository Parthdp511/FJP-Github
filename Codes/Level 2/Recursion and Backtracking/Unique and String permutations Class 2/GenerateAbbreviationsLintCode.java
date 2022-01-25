public class Solution {
    /**
     * @param word: the given word
     * @return: the generalized abbreviations of a word
     */

    List<String> res;

    public void generate(String input, String output, int idx, int count){
        if(idx == input.length()){
            if(count == 0)      res.add(output);
            else                res.add(output + count);
            return;
        }

        char ch = input.charAt(idx);
        generate(input, output + ((count == 0) ? "" : count) + ch, idx + 1, 0);
        generate(input, output, idx + 1, count + 1);
    }

    public List<String> generateAbbreviations(String word) {
        // Write your code here
        res = new ArrayList<>();
        generate(word, "", 0, 0);
        return res;
    }
}

   
