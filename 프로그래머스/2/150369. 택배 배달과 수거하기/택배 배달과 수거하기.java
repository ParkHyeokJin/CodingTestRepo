import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> deliverStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        for(int i = 0; i < n; i++){
            deliverStack.push(deliveries[i]);
            pickupStack.push(pickups[i]);
        }

        while (!deliverStack.isEmpty() || !pickupStack.isEmpty()){
            int dlvIdx, picIdx;

            dlvIdx = getDlvOrPicIdx(cap, deliverStack);
            picIdx = getDlvOrPicIdx(cap, pickupStack);

            answer += Math.max(dlvIdx, picIdx);
        }

        return answer * 2;
    }

    private static int getDlvOrPicIdx(int cap, Stack<Integer> stack) {
        int sumBox = 0;
        int moveIdx = 0;
        while (!stack.isEmpty()){
            if(stack.peek() == 0){
                stack.pop();
                continue;
            }

            moveIdx = Math.max(stack.size(), moveIdx);
            sumBox += stack.pop();
            if(sumBox >= cap){
                stack.push(sumBox - cap);
                break;
            }
        }
        return moveIdx;
    }
}