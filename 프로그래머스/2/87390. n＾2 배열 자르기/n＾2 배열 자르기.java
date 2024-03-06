import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int idx = 0;
        for (int i = 0; i < answer.length; i++) {
            int y = (int) (left / n + 1);
            int x = (int) (left % n + 1);
            left++;
            answer[idx++] = Math.max(y, x);
        }
        return answer;
    }
}