import java.util.*;

class Solution {
    
    private String[] alphabet = {"A", "E", "I", "O", "U"};
    private List<String> dictionary= new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        
        dfs("");
        answer = dictionary.indexOf(word);
        
        return answer;
    }
    
    private void dfs(String str){
        dictionary.add(str);
        if(str.length() >= alphabet.length){
            return;
        }
        for(String a : alphabet){
            dfs(str + a);
        }
    }
}