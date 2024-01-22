import java.util.*;

class Solution {
    private List<int[]> answers;
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        answers = new ArrayList<>();

        findTwoPointerPairWithSum(sequence, k);

        answers.sort(Comparator.comparingInt(ints -> ints[1] - ints[0]));
        answer = answers.get(0);
        return answer;
    }

    private void findTwoPointerPairWithSum(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int currentSum = sequence[0];

        while(true){
            if(k == currentSum){
                answers.add(new int[]{start, end});
            }
            if(start == sequence.length && end == sequence.length){
                break;
            }
            if(currentSum <= k && end < sequence.length){
                end++;
                if(end < sequence.length){
                    currentSum += sequence[end];
                }
            }else{
                if(start < sequence.length){
                    currentSum -= sequence[start];
                }
                start++;
            }
        }
    }
}