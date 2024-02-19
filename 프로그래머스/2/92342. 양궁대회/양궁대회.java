import java.util.*;
class Solution {
    public int[] solution(int n, int[] info) {
        int[] answer = new int[info.length];
        answer = getWinLionScore(n, info, answer);
        return answer;
    }
    
    private int[] getWinLionScore(int n, int[] info, int[] answer) {
        Queue<State> queue = new LinkedList<>();

        int apeachTotalScore = 0;
        for(int i = 0 ; i < info.length; i++){
            if(info[i] > 0) apeachTotalScore += 10 - i;
        }

        queue.add(new State(n, 0, apeachTotalScore, new int[info.length], new boolean[info.length]));

        int maxDiffScore = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (state.lionHitCnt == 0) {
                if(state.lionScore > state.apeachScore
                        && state.lionScore - state.apeachScore >= maxDiffScore){
                    maxDiffScore = state.lionScore - state.apeachScore;
                    for(int j = 10; j >= 0; j--){
                        if(state.lionInfo[j] > answer[j]){
                            answer = state.lionInfo;
                            break;
                        }
                    }
                }
                continue;
            }

            for (int i = 0; i < info.length; i++) {
                if (!state.visited[i]) {
                    state.visited[i] = true;

                    int newLionArrow = state.lionHitCnt;
                    int newLionScore = state.lionScore;
                    int newApeachScore = state.apeachScore;
                    int[] newLionInfo = Arrays.copyOf(state.lionInfo, state.lionInfo.length);

                    if(info[i] > 0 && state.lionHitCnt > info[i]) {  //라이언이 점수를 뺏는 경우
                        newLionInfo[i] = info[i] + 1;
                        newLionArrow -= info[i] + 1;
                        newLionScore += 10 - i;
                        newApeachScore -= 10 - i;
                    } else if (info[i] == 0) {//라이언이 점수를 획득 하는 경우(어피치가 쏘지 않은 과녁)
                        newLionInfo[i] = 1;
                        newLionArrow -= 1;
                        newLionScore += 10 - i;
                    } else{  //남은 화살 소모
                        newLionInfo[i] = state.lionHitCnt;
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
        private int lionHitCnt;
        private int lionScore;
        private int apeachScore;
        private int[] lionInfo;
        private boolean[] visited;

        public State(int lionHitCnt, int lionScore, int apeachScore, int[] lionInfo, boolean[] visited) {
            this.lionHitCnt = lionHitCnt;
            this.lionScore = lionScore;
            this.apeachScore = apeachScore;
            this.lionInfo = lionInfo;
            this.visited = visited;
        }
    }
}