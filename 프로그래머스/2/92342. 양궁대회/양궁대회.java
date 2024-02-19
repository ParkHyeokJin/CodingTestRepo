import java.util.*;
class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        answer = getWinLionScore(n, info, answer);
        return answer;
    }
    
    private int[] getWinLionScore(int n, int[] info, int[] answer) {
        Queue<State> queue = new LinkedList<>();

        int apeacheTotalScore = 0;
        for(int i = 0 ; i < info.length; i++){
            if(info[i] > 0) apeacheTotalScore += 10 - i;
        }

        queue.add(new State(n, 0, apeacheTotalScore, new int[info.length], new boolean[info.length]));

        int maxDiffScore = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.lionArrow == 0 && state.lionScore > state.apeachScore) {
                if(state.lionScore - state.apeachScore >= maxDiffScore){
                    maxDiffScore = state.lionScore - state.apeachScore;
                    for(int j = 10; j >= 0; j--){
                        if(state.lionShots[j] > answer[j]){
                            answer = state.lionShots;
                            break;
                        }
                    }
                    continue;
                }
                continue;
            }else if(state.lionArrow == 0 && state.apeachScore > state.lionScore){
                continue;
            }

            for (int i = 0; i < info.length; i++) {
                if (!state.visited[i]) {
                    state.visited[i] = true;

                    int newLionArrow = state.lionArrow;
                    int newLionScore = state.lionScore;
                    int newApeachScore = state.apeachScore;
                    int[] newLionInfo = Arrays.copyOf(state.lionShots, state.lionShots.length);

                    if(info[i] > 0 && state.lionArrow > info[i]) {  //라이언이 점수를 뺃는 경우
                        newLionInfo[i] = info[i] + 1;
                        newLionArrow -= info[i] + 1;
                        newLionScore += 10 - i;
                        newApeachScore -= 10 - i;
                    } else if (info[i] == 0) {//라이언이 점수를 획득 하는 경우(어피치가 쏘지 않은 과녁)
                        newLionInfo[i] = 1;
                        newLionArrow -= 1;
                        newLionScore += 10 - i;
                    } else{  //남은 화살 소모
                        newLionInfo[i] = state.lionArrow;
                        newLionArrow = 0;
                    }
                    boolean[] newVisited = Arrays.copyOf(state.visited, state.visited.length);
                    queue.offer(new State(newLionArrow, newLionScore, newApeachScore, newLionInfo, newVisited));
                }
            }
        }
        return maxDiffScore == Integer.MIN_VALUE ? new int[]{-1} : answer;
    }
    
    class State {
        private int lionArrow;
        private int lionScore;
        private int apeachScore;
        private int[] lionShots;
        private boolean[] visited;

        public State(int lionArrow, int lionScore, int apeachScore, int[] lionShots, boolean[] visited) {
            this.lionArrow = lionArrow;
            this.lionScore = lionScore;
            this.apeachScore = apeachScore;
            this.lionShots = lionShots;
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "State{" +
                    "lionArrow=" + lionArrow +
                    ", lionScore=" + lionScore +
                    ", apeachScore=" + apeachScore +
                    ", lionShots=" + Arrays.toString(lionShots) +
                    ", visited=" + Arrays.toString(visited) +
                    '}';
        }
    }
}