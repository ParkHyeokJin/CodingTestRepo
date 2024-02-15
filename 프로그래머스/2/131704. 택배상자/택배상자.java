import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subBelt = new Stack<>();

        int orderIdx = 0;
        for(int i = 1; i <= order.length; i++){
            if(i == order[orderIdx]){
                answer++;
                orderIdx++;
            }else{
                if(subBelt.isEmpty()){
                    subBelt.push(i);
                }else {
                    while (!subBelt.isEmpty()){
                        if(subBelt.peek() != order[orderIdx]){
                            break;
                        }
                        subBelt.pop();
                        answer++;
                        orderIdx++;
                    }
                    subBelt.push(i);
                }
            }
        }

        while (!subBelt.isEmpty()){
            if(subBelt.peek() == order[orderIdx]){
                subBelt.pop();
                orderIdx++;
                answer++;
            }else{
                break;
            }
        }
        
        return answer;
    }
}