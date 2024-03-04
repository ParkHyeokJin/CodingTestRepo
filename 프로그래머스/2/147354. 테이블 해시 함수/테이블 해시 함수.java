import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (d1, d2) -> {
            if (d1[col - 1] == d2[col - 1]) {
                return Integer.compare(d2[0], d1[0]);
            }
            return Integer.compare(d1[col - 1], d2[col - 1]);
        });

        for(int i = row_begin - 1; i < row_end; i++){
            int sum = 0;
            for(int j = 0; j < data[i].length; j++){
                sum += data[i][j] % (i + 1);
            }
            answer ^= sum;
        }
        
        return answer;
    }
}