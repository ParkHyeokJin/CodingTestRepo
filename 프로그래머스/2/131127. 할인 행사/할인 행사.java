import java.util.*;
class Solution {
    private static final int buyDay = 10;
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for(int i = 0; i <= discount.length - buyDay; i++){
            Map<String, Integer> discountDaysItem = new HashMap<>();
            for(int j = i; j < i + buyDay; j++){
                discountDaysItem.put(discount[j], discountDaysItem.getOrDefault(discount[j], 0) + 1);
            }
            map.put(i, discountDaysItem);
        }

        for(Integer day : map.keySet()){
            answer += checkItem(map.get(day), want, number);
        }

        return answer;
    }

    private int checkItem(Map<String, Integer> itemMap, String[] want, int[] number){
        for(int i = 0; i < want.length; i++){
            String item = want[i];
            int count = number[i];
            if(!itemMap.containsKey(item)){
                return 0;
            }
            if(!(itemMap.get(item) == count)){
                return 0;
            }
        }
        return 1;
    }
}