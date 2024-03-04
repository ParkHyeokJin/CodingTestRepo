import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> boxMap = new HashMap<>();
        for(int i : tangerine){
            boxMap.put(i, boxMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> keySet = new ArrayList<>(boxMap.keySet());

        keySet.sort((t1, t2) -> boxMap.get(t2).compareTo(boxMap.get(t1)));

        int tangerineCnt = 0;
        for(int key : keySet){
            tangerineCnt += boxMap.get(key);
            answer++;
            if(tangerineCnt >= k){
                break;
            }
        }

        return answer;
    }
}