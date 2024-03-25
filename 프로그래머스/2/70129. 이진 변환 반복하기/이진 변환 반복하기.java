import java.util.*;
class Solution {
    private int convertCnt = 0;
    private int zeroCnt = 0;

    public int[] solution(String s) {
        int[] answer = {};
        getConvertStoBinaryCnt(s);
        return new int[]{convertCnt, zeroCnt};
    }

    private void getConvertStoBinaryCnt(String s) {
        if(s.length() == 1){
            return;
        }
        convertCnt++;
        char[] sArr = s.toCharArray();
        int oneCnt = 0;
        for(char c : sArr){
            if(c == '0'){
                zeroCnt++;
            }else{
                oneCnt++;
            }
        }
        getConvertStoBinaryCnt(Long.toBinaryString(oneCnt));
    }
}