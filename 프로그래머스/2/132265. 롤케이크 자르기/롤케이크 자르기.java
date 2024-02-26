import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        //idx
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        leftMap.put(topping[0], 1);
        for(int i = 1; i < topping.length; i++){
            rightMap.put(topping[i], rightMap.getOrDefault(topping[i], 0) + 1);
        }

        for(int i = 1; i < topping.length; i++){
            int num = topping[i];
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);

            int count = rightMap.get(num);
            if(count > 1){
                rightMap.put(num, count - 1);
            }else{
                rightMap.remove(num);
            }

            if(leftMap.keySet().size() == rightMap.keySet().size()){
                answer++;
            }
        }
        return answer;
    }
}