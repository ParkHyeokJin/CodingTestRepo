import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        checkSquare(0, arr.length, 0, arr[0].length, arr.length, arr);
        return new int[]{zeroCnt, oneCnt};
    }


    private int zeroCnt = 0;
    private int oneCnt = 0;
    private void checkSquare(int iSidx, int iEidx, int jSidx, int jEidx, int len, int[][] arr){
        boolean chk = true;
        for(int i = iSidx; i < iEidx; i++){
            int chkNum = arr[iSidx][jSidx];
            for(int j = jSidx; j < jEidx; j++){
                if (chkNum != arr[i][j]) {
                    chk = false;
                    break;
                }
            }
            if(!chk) break;
        }
        if(chk){
            if (arr[iSidx][jSidx] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
        }else{
            len /= 2;
            checkSquare(iSidx, iEidx - len, jSidx, jEidx - len, len, arr);
            checkSquare(iSidx, iEidx - len, jSidx + len, jEidx, len, arr);
            checkSquare(iSidx + len, iEidx, jSidx, jEidx - len, len, arr);
            checkSquare(iSidx + len, iEidx, jSidx + len, jEidx, len, arr);
        }
    }
}