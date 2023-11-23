import java.util.*;
class Solution {
    private boolean[] visited;
    private List<String> location = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        String[] answer = {};

        visited = new boolean[tickets.length];

        dfs(0, "ICN", "ICN", tickets);

        Collections.sort(location);

        answer = location.get(0).split(" ");

        return answer;
    }

    private void dfs(int idx, String air, String path, String[][] tickets){
        if(idx == tickets.length) {
            location.add(path);
        }
        for(int i = 0; i < tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(air)){
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], path + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}