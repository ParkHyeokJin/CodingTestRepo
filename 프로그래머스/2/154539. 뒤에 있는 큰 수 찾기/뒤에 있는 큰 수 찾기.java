import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();
        for(int i = numbers.length-1; i>-1; i--){
            while (!stack.empty() && numbers[i] >= stack.peek()){
                stack.pop();
            }
            if(!stack.empty()){
                answer[i] = stack.peek();
            }
            stack.push(numbers[i]);
        }
        return answer;
    }
}