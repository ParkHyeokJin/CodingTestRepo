import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 1;

        int o = 0;
        int x = 0;
        int n = 0;
        for (String s : board) {
            for (int j = 0; j < s.length(); j++) {
                String item = String.valueOf(s.charAt(j));
                if ("O".equals(item)) {
                    o++;
                } else if ("X".equals(item)) {
                    x++;
                } else {
                    n++;
                }
            }
        }
        if(n == 9){
            return 1;
        } else if(x - o > 0 || o - x > 1){
            return 0;
        } else {
            boolean O_bingo = checkWidthBingo("O", board);
            boolean X_bingo = checkWidthBingo("X", board);

            if(O_bingo && X_bingo) {
                return 0;
            }else if(O_bingo){
                if(o - x == 1) {
                    return 1;
                }
                return 0;
            }else if(X_bingo){
                if(x == o){
                    return 1;
                }
                return 0;
            }

            boolean O_Hbingo = checkHeightBingo("O", board);
            boolean X_Hbingo = checkHeightBingo("X", board);

            if(O_Hbingo && X_Hbingo) {
                return 0;
            }else if(O_Hbingo){
                if(o - x == 1) {
                    return 1;
                }
                return 0;
            }else if(X_Hbingo){
                if(x == o){
                    return 1;
                }
                return 0;
            }


            boolean O_diagBingo = checkDiagBingo("O", board);
            boolean X_diagBingo = checkDiagBingo("X", board);

            if(O_diagBingo && X_diagBingo) {
                return 0;
            }else if(O_diagBingo){
                if(o - x == 1) {
                    return 1;
                }
                return 0;
            }else if(X_diagBingo){
                if(x == o){
                    return 1;
                }
                return 0;
            }

            if(o == x) return 1;
        }




        return answer;
    }

    private boolean checkWidthBingo(String item, String[] board){
        boolean result = false;
        for (String s : board) {
            if (String.valueOf(s.charAt(0)).equals(item)) {
                int cnt = 0;
                for (int j = 0; j < board[0].length(); j++) {
                    if (String.valueOf(s.charAt(j)).equals(item)) {
                        cnt++;
                    }
                }
                if (cnt == 3) return true;
            }
        }
        return result;
    }

    private boolean checkHeightBingo(String item, String[] board){
        for (int i = 0 ; i < board.length; i++) {
            if(String.valueOf(board[0].charAt(i)).equals(item)
                    && String.valueOf(board[1].charAt(i)).equals(item)
                    && String.valueOf(board[2].charAt(i)).equals(item)
            ){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagBingo(String item, String[] board){
        if(String.valueOf(board[1].charAt(1)).equals(".")) return false;

        if(String.valueOf(board[0].charAt(0)).equals(item)
            && String.valueOf(board[1].charAt(1)).equals(item)
            && String.valueOf(board[2].charAt(2)).equals(item)){
            return true;
        }else if(String.valueOf(board[0].charAt(2)).equals(item)
            && String.valueOf(board[1].charAt(1)).equals(item)
            && String.valueOf(board[2].charAt(0)).equals(item)
        ){
            return true;
        }
        return false;
    }
}