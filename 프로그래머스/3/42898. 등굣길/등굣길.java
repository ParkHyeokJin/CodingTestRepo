import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int mod = 1_000_000_007;
        
        int[][] dp = new int[n + 1][m + 1];

        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }

        dp[1][1] = 1; //시작점
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j++){
                if(dp[i][j] == -1) continue;
                if(dp[i - 1][j] >= 0) dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                if(dp[i][j - 1] >= 0) dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
            }
        }        
        
        answer = dp[n][m];
        return answer;
    }
}