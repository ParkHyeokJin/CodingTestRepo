import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        if(k == enemy.length) return enemy.length;
        
        Queue<Integer> invincibleQueue = new PriorityQueue<>();
        for(int e : enemy){
            if(k > 0){
                k--;
                invincibleQueue.add(e);
            }else{
                int num = e;
                //현재 들어온 병사가 더 많으면 변경 한다.
                if(invincibleQueue.peek() < e){
                    num = invincibleQueue.poll();
                    invincibleQueue.add(e);
                }

                if(n >= num){
                    n -= num;
                }else{
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}