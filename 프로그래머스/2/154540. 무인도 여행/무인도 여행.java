import java.util.*;

class Solution {
    private static final int[] X_POS = {1, -1, 0, 0};
    private static final int[] Y_POS = {0, 0, 1, -1};
    public int[] solution(String[] maps) {
        int[] answer = new int[]{-1};

        boolean[][] visited = new boolean[maps.length + 1][maps[0].length() + 1];
        int[][] map = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                String tmp = String.valueOf(maps[i].charAt(j));
                if("X".equals(tmp)){
                    map[i][j] = Integer.MIN_VALUE;
                }else{
                    map[i][j] = Integer.parseInt(tmp);
                }
            }
        }

        List<Integer> foods = new ArrayList<>();
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] > 0 && !visited[i][j]){
                   foods.add(dfs(i, j, visited, map));
                }
            }
        }
        
        if(!foods.isEmpty()){
            answer = foods.stream().sorted().mapToInt(i -> i).toArray();
        }
        return answer;
    }

    private int dfs(int x, int y, boolean[][] visited, int[][] map){
        int sumFood = map[x][y];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int nowX = curX + X_POS[i];
                int nowY = curY + Y_POS[i];

                if(nowX >= 0 && nowX < map.length
                && nowY >= 0 && nowY < map[nowX].length && !visited[nowX][nowY] && map[nowX][nowY] > 0){
                    sumFood += map[nowX][nowY];
                    queue.add(new int[]{nowX, nowY});
                    visited[nowX][nowY] = true;
                }
            }
        }

        return sumFood;
    }
}