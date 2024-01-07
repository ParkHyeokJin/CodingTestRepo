import java.util.*;
class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];

        int maxNum = 0; //정점의 개수
        Map<Integer, DataClass> map = new HashMap<>();

        for(int i = 0 ; i < edges.length; i++){
            int giveNum = edges[i][0];
            int receiveNum = edges[i][1];

            if(maxNum < giveNum) maxNum = giveNum;
            if(maxNum < receiveNum) maxNum = receiveNum;

            if(!map.containsKey(giveNum)) map.put(giveNum, new DataClass(0, 0));
            if(!map.containsKey(receiveNum)) map.put(receiveNum, new DataClass(0, 0));

            map.get(giveNum).giveNum++;
            map.get(receiveNum).receiveNum++;
        }

        for(int i = 1; i <= maxNum; i++){
            int giveCount = map.get(i).giveNum;
            int receiveCount = map.get(i).receiveNum;

            if(receiveCount == 0 && giveCount >= 2){
                answer[0] = i;
            }else if(map.get(i).giveNum == 0){
                //막대
                answer[2]++;
            }else if(map.get(i).receiveNum >= 2 && map.get(i).giveNum >= 2){
                //8자
                answer[3]++;
            }

        }
        // 도넛 모양 그래프는 특이 정점이 없으므로 전체 개수에서 나머지 그래프 개수 뺀 나머지를 넣어줌
        answer[1] = map.get(answer[0]).giveNum - answer[2] - answer[3];

        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public class DataClass{
        private int giveNum;
        private int receiveNum;
        public DataClass(int giveNum, int receiveNum) {
            this.giveNum = giveNum;
            this.receiveNum = receiveNum;
        }
    }
}