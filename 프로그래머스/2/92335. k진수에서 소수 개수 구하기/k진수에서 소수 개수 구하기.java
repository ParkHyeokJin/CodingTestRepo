import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String convertNumberStr = Long.toString(n, k);
        StringTokenizer st = new StringTokenizer(convertNumberStr, "0");
        while (st.hasMoreTokens()){
            if(chkPrimeNumber(st.nextToken())){
                answer++;
            }
        }
        return answer;
    }

    private boolean chkPrimeNumber(String item) {
        long number = Long.parseLong(Long.toString(Long.parseLong(item), 10));
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}