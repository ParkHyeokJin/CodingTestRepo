import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        
        for(int i = 1; i < triangle.length; i++){
            dp[i][0] = dp[i - 1][0] + triangle[i][0];  //맨 왼쪽 자리 탐색
            
            for(int j = 1; j <= i-1; j++){  //중간자리 탐색
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
            
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i]; //맨 오른쪽 자리 탐색
        }
        
        for(int n : dp[dp.length -1]){
            if(answer < n){
                answer = n;
            }
        }
        
        
        return answer;
    }
}