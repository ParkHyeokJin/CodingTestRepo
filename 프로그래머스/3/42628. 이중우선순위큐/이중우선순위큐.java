import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;
        while(idx < operations.length){
            String[] input = operations[idx++].split(" ");
            String op = input[0];
            int num = Integer.parseInt(input[1]);
            if(op.equals("I")){
                if(deque.isEmpty()){
                    deque.add(num);
                }else if(deque.peekFirst() > num){
                    deque.addFirst(num);
                } else if (deque.peekLast() < num) {
                    deque.addLast(num);
                }
            }else if(op.equals("D")){
                if(num == 1){
                    if(!deque.isEmpty()){
                        deque.removeLast();
                    }
                }else if(num == -1){
                    if(!deque.isEmpty()){
                        deque.removeFirst();
                    }
                }
            }
        }

        if(deque.isEmpty()){
            answer = new int[]{0,0};
        }else{
            answer = new int[]{deque.getLast(), deque.getFirst()};
        }
        return answer;
    }
}