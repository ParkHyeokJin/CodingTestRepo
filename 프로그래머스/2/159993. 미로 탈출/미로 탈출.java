import java.util.*;
class Solution {
    private int[] startPos;
    private int[] endPos;
    private int[] leverPos;
    private String[][] convertMap;

    private int[] X_POS = {-1, 1, 0, 0};
    private int[] Y_POS = {0, 0, -1, 1};
    public int solution(String[] maps) {
        int answer = -1;
        convertMap = new String[maps.length][maps[0].length()];

        for(int i = 0 ; i < maps.length; i++){
            for(int j = 0 ; j < maps[i].length(); j++){
                String tmp = String.valueOf(maps[i].charAt(j));
                convertMap[i][j] = tmp;
                switch (tmp) {
                    case "S":
                        startPos = new int[]{i, j};
                        break;
                    case "E":
                        endPos = new int[]{i, j};
                        break;
                    case "L":
                        leverPos = new int[]{i, j};
                        break;
                }
            }
        }
        int leverFindTime = findLever();
        int endFindTime = findEnd();

        if(leverFindTime > 0 && endFindTime > 0){
            answer = leverFindTime + endFindTime;
        }
        return answer;
    }

    private int findLever() {
        int time = -1;
        Queue<Index> queue = new LinkedList<>();
        boolean[][] visited = new boolean[convertMap.length][convertMap[0].length];
        queue.add(new Index(startPos[0], startPos[1], 0));
        visited[startPos[0]][startPos[1]] = true;

        while (!queue.isEmpty()){
            Index cur = queue.poll();
            int x = cur.X;
            int y = cur.Y;

            if(x == leverPos[0] && y == leverPos[1]){
                time = cur.seconds;
                break;
            }

            for(int i = 0; i < 4; i++){
                int next_X = x + X_POS[i];
                int next_Y = y + Y_POS[i];

                if(next_X >= 0 && next_X < convertMap.length
                && next_Y >= 0 && next_Y < convertMap[0].length){
                    if(!visited[next_X][next_Y] && !"X".equals(convertMap[next_X][next_Y])){
                        queue.add(new Index(next_X, next_Y, cur.seconds + 1));
                        visited[next_X][next_Y] = true;
                    }
                }
            }
        }
        return time;
    }

    private int findEnd() {
        int time = -1;
        Queue<Index> queue = new LinkedList<>();
        boolean[][] visited = new boolean[convertMap.length][convertMap[0].length];
        queue.add(new Index(leverPos[0], leverPos[1], 0));
        visited[leverPos[0]][leverPos[1]] = true;

        while (!queue.isEmpty()){
            Index cur = queue.poll();
            int x = cur.X;
            int y = cur.Y;

            if(x == endPos[0] && y == endPos[1]){
                time = cur.seconds;
                break;
            }

            for(int i = 0; i < 4; i++){
                int next_X = x + X_POS[i];
                int next_Y = y + Y_POS[i];

                if(next_X >= 0 && next_X < convertMap.length
                        && next_Y >= 0 && next_Y < convertMap[0].length){
                    if(!visited[next_X][next_Y] && !"X".equals(convertMap[next_X][next_Y])){
                        queue.add(new Index(next_X, next_Y, cur.seconds + 1));
                        visited[next_X][next_Y] = true;
                    }
                }
            }
        }
        return time;
    }

    class Index{
        private int X;
        private int Y;
        private int seconds;

        public Index(int x, int y, int seconds) {
            this.X = x;
            this.Y = y;
            this.seconds = seconds;
        }
    }
}