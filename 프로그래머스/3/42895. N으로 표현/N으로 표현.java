import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        List<Set<Integer>> list = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            list.add(new HashSet<>());
        }                
        
        list.get(1).add(N);
        
        for(int i = 2; i < 9; i++){
            list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
            for(int j = 1; j < i; j++){
                Set<Integer> num1 = list.get(j);
                Set<Integer> num2 = list.get(i - j);
                
                for(int n1 : num1){
                    for(int n2 : num2){
                        list.get(i).add(n1 + n2);
                        list.get(i).add(n1 - n2);
                        list.get(i).add(n1 * n2);
                        if(n2 > 0) {
                            list.get(i).add(n1 / n2);
                        }
                    }
                }
            }
        }
        
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).contains(number)){
                return i;
            }
        }
        
        return answer;
    }
}