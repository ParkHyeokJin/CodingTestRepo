import java.util.*;
class Solution {
    private static final int[][] MINING_FATIGUE = new int[][]{{1,1,1}, {5,1,1}, {25,5,1}};
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        int picksCnt = Arrays.stream(picks).sum();
        List<Mineral> list = new ArrayList<>();

        for(int i =0; i < minerals.length; i+=5){
            int diamond = 0, iron = 0, stone = 0;
            if(picksCnt == 0) break;

            for(int j = i; j < i + 5; j++){
                int mineralType;
                if(j == minerals.length){
                    break;
                }
                if("diamond".equals(minerals[j])){
                    mineralType = 0;
                }else if("iron".equals(minerals[j])){
                    mineralType = 1;
                }else{
                    mineralType = 2;
                }
                diamond += MINING_FATIGUE[0][mineralType];
                iron += MINING_FATIGUE[1][mineralType];
                stone += MINING_FATIGUE[2][mineralType];
            }
            list.add(new Mineral(diamond, iron, stone));
            picksCnt--;
        }

        list.forEach(System.out::println);

        list.sort((o1, o2) -> o2.stone - o1.stone);
        for(Mineral m : list){
            int diamond = m.diamond;
            int iron = m.iron;
            int stone = m.stone;

            if(picks[0] > 0){
                answer += diamond;
                picks[0]--;
                continue;
            }

            if(picks[1] > 0){
                answer += iron;
                picks[1]--;
                continue;
            }

            if(picks[2] > 0){
                answer += stone;
                picks[2]--;
            }
        }

        return answer;
    }

    static class Mineral{
        private int diamond;
        private int iron;
        private int stone;

        public Mineral(int diamond, int iron, int stone) {
            this.diamond = diamond;
            this.iron = iron;
            this.stone = stone;
        }

        @Override
        public String toString() {
            return "Mineral{" +
                    "diamond=" + diamond +
                    ", iron=" + iron +
                    ", stone=" + stone +
                    '}';
        }
    }
}