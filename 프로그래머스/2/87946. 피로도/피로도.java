import java.util.*;

class Solution {
    
    private static int cnt = -1;
    private static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        dfs(0, dungeons, visited, k);
        answer = cnt;
        return answer;
    }
    
    private void dfs(int idx, int[][] dungeons, boolean[] visited, int k) {
        for(int i = 0; i < dungeons.length; i++){
            if(dungeons[i][0] <= k && !visited[i]){
                visited[i] = true;
                dfs(idx + 1, dungeons, visited, k - dungeons[i][1]);
                visited[i] = false;
            }
        }
        cnt = Math.max(cnt, idx);
    }
}