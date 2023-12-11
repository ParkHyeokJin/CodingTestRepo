import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] matchs = new int[n][n];

        for(int i = 0; i < results.length; i++){
            int x = results[i][0];
            int y = results[i][1];
            
            matchs[x-1][y-1] = 1;
            matchs[y-1][x-1] = -1;
        }
        
        for(int k = 0; k < n; k++){
            for(int s = 0; s < n; s++){
                for(int e = 0; e < n; e++){
                    if(matchs[s][k] == 1 && matchs[k][e] == 1){
                        matchs[s][e] = 1;
                        matchs[e][s] = -1;
                    }
                    if(matchs[s][k] == -1 && matchs[k][e] == -1){
                        matchs[s][e] = -1;
                        matchs[e][s] = 1;
                    }
                }
            }
        }
        
        for(int[] match : matchs){
            int matchCnt = 0;
            for(int m : match){
                if(m != 0) matchCnt++;
            }
            if(matchCnt == n - 1) answer++;
        }
        
        return answer;
    }
}