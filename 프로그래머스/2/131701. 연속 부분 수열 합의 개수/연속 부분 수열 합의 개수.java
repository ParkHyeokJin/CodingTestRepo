import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;

        for(int i = 1; i <= elements.length; i++) {
            dfs(i, 0, elements);
        }

        answer = set.size();
        return answer;
    }

    public void dfs(int len, int pos, int[] elements){
        if(pos > elements.length){
            return;
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(pos + i >= elements.length){
                sum += elements[pos + i - elements.length];
                continue;
            }
            sum += elements[pos + i];
        }
        set.add(sum);
        dfs(len, pos + 1, elements);
    }
}