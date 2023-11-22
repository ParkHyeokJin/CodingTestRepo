import java.util.*;

class Solution {
    private List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i < graph.length; i++){
            graph[i] = new ArrayList();
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];       
            boolean[] visited = new boolean[n + 1];
            
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            int cnt = dfs(1, visited);
            int num = Math.abs(cnt - (n - cnt));
            
            answer = Math.min(num, answer);
            
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        return answer;
    }
    
    private int dfs(int idx, boolean[] visited){
        int cnt = 1;
        visited[idx] = true;
        
        for(int i = 0; i < graph[idx].size(); i++){
            if(!visited[graph[idx].get(i)]){
                cnt += dfs(graph[idx].get(i), visited);
            }
        }
        return cnt;
    }
}