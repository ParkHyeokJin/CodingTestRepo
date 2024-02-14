import java.util.*;
class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey != 0){
            int tmp = storey % 10;
            if(tmp > 5){
                storey = (storey + 10 - tmp) / 10;
                answer += 10 - tmp;
            }else if(tmp == 5){
                int tmp2 = ((storey - tmp) / 10) % 10 ;
                if(tmp2 >= 5){
                    storey = (storey + 10 - tmp) / 10;
                    answer += 10 - tmp;
                }else{
                    storey = (storey - tmp) / 10;
                    answer += tmp;
                }
            }else{
                storey = (storey - tmp) / 10;
                answer += tmp;
            }
        }
        return answer;
    }
}