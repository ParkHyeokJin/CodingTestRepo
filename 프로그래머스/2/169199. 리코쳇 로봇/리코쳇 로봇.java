import java.util.*;
class Solution {
    private static final String START = "R";
    private static final String GOAL = "G";
    private static final String SPACE = ".";
    private static final String WALL = "D";

    private static final int[] POS_X = {0, 0, -1, 1};
    private static final int[] POS_Y = {-1, 1, 0, 0};
    public int solution(String[] board) {
        int answer = -1;

        int[][] map = new int[board.length][board[0].getBytes().length];
        boolean[][] visited = new boolean[board.length + 1][board[0].getBytes().length + 1];

        Queue<Position> queue = new LinkedList<>();
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[i].getBytes().length; j++) {
                if(START.equals(String.valueOf(board[i].charAt(j)))){
                    queue.add(new Position(i, j, 0));
                    break;
                }
            }
        }

        while (!queue.isEmpty()){
            Position nowPosition = queue.poll();
            visited[nowPosition.x][nowPosition.y] = true;

            if(GOAL.equals(String.valueOf(board[nowPosition.x].charAt(nowPosition.y)))){
                System.out.println("GOAL : " + nowPosition);
                answer = nowPosition.moveCnt;
                break;
            }
            for(int i = 0; i < 4; i++){
                int cur_x = nowPosition.x;
                int cur_y = nowPosition.y;

                int next_x = nowPosition.x + POS_X[i];
                int next_y = nowPosition.y + POS_Y[i];

                while(next_x >= 0 && next_x < board.length
                        && next_y >= 0 && next_y < board[0].getBytes().length
                        && !WALL.equals(String.valueOf(board[next_x].charAt(next_y)))){
                    next_x += POS_X[i];
                    next_y += POS_Y[i];

                    cur_x += POS_X[i];
                    cur_y += POS_Y[i];
                }
                if(!visited[cur_x][cur_y]){
                    visited[cur_x][cur_y] = true;
                    queue.offer(new Position(cur_x, cur_y, nowPosition.moveCnt+1));
                }
            }
        }
        return answer;
    }

    static class Position{
        int x;
        int y;
        int moveCnt;
        public Position(int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    ", moveCnt=" + moveCnt +
                    '}';
        }
    }
}