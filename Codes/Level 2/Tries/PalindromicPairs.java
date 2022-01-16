import java.util.*;

class Solution {

    public static class Node{
        Node[] children = new Node[26];
        int index;
        ArrayList<Integer> ids;

        public Node(){
            this.children = new Node[26];
            this.ids = new ArrayList<Integer>();
            this.index = -1;
        }
    }

    public boolean isPalin(char[] str, int i, int j){
        while( j - i > 0){
            if(str[i++] != str[j--])
                return false;
        }
        return true;
    }

    public void insert(String word, int idx){
        char [] wd = word.toCharArray();
        Node curr = root;
        for(int i=0; i<wd.length; i++){
            int pt = wd[i] - 'a';
            if(curr.children[pt] == null){
                curr.children[pt] = new Node();
            }

            curr = curr.children[pt];

            if(i == wd.length - 1){
                curr.index = idx;
            }

            if(isPalin(wd, i+1, wd.length - 1)){
                curr.ids.add(idx);
            }
        }
    }

    public void search(String word, List<List<Integer>> list, int idx, List<Integer> empty){
        char[] wd = word.toCharArray();
        Node curr = root;

        for(int i = wd.length - 1; i >= 0; i--){
            int pt = wd[i] - 'a';
            if(curr.index != -1 && isPalin(wd, 0, i)){
                List<Integer> li = new ArrayList<Integer>();
                li.add(curr.index);
                li.add(idx);
                list.add(li);
            }
            if(curr.children[pt] == null)   
                return;
            curr = curr.children[pt];
        }

        if(curr.ids.size() != 0){
            for(Integer in : curr.ids){
                if(in != idx){
                    List<Integer> li = new ArrayList<Integer>();
                    li.add(in);
                    li.add(idx);
                    list.add(li);
                }else{
                    for(Integer em : empty){
                        List<Integer> li = new ArrayList<Integer>();
                        li.add(em);
                        li.add(idx);
                        list.add(li);
                        li = new ArrayList<Integer>();
                        li.add(idx);
                        li.add(em);
                        list.add(li);
                    }
                }
            }
        }
    }

    Node root;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(words.length < 2)    return list;

        List<Integer> empty = new ArrayList<Integer>();
        root = new Node();

        for(int i=0; i<words.length; i++){
            if(words[i].length() == 0){
                empty.add(i);
                continue;
            }
            insert(words[i], i);
        }

        for(int i=0; i<words.length; i++){
            search(words[i], list, i, empty);
        }

        return list;
    }
}