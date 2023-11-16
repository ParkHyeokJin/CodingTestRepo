import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] stu1 = new int[]{1, 2, 3, 4, 5};
        int[] stu2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] stu3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] score = new int[3];
        score[0] = check(answers, stu1);
        score[1] = check(answers, stu2);
        score[2] = check(answers, stu3);

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        List<Integer> maxScoreList = new ArrayList<>();
        for(int i =0 ; i < score.length; i ++){
            if(score[i] == max) {
                maxScoreList.add(i+1);
            }
        }

        answer = new int[maxScoreList.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = maxScoreList.get(i);
        }
        return answer;
    }

    private int check(int[] answers, int[] stu) {
        int answerCnt = 0;
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == stu[i%stu.length]){
                answerCnt++;
            }
        }
        return answerCnt;
    }
}