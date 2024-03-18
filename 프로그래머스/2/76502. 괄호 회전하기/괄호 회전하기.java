import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        String str;
        for(int i =0; i < s.length(); i++){
            String turnStr = s.substring(0, i);
            str = s.substring(i) + turnStr;
            answer += check(str);
        }

        System.out.println(answer);
        return answer;
    }

    private int check(String str) {
        Stack<String> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '[' || c == '(' || c == '{'){
                stack.push(String.valueOf(c));
            }else{
                if(stack.isEmpty()){
                    stack.push(String.valueOf(c));
                    continue;
                }
                if(c == ']' && stack.peek().equals("[") ) {
                    stack.pop();
                }else if(c == ')' && stack.peek().equals("(")){
                    stack.pop();
                }else if(c == '}' && stack.peek().equals("{")){
                    stack.pop();
                }
            }
        }
        return !stack.isEmpty() ? 0 : 1;
    }
}