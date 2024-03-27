import java.util.*;
class Solution {
    public int[] solution(String s) {
        // 문자열 s에서 집합을 나타내는 중괄호 '{', '}'를 제거하고 튜플을 나타내는 문자열들을 얻음
        String[] tuples = s.substring(2, s.length() - 2).split("\\},\\{");

        // 문자열들을 길이에 따라 정렬
        Arrays.sort(tuples, Comparator.comparingInt(String::length));

        List<Integer> answerList = new ArrayList<>();
        for (String tuple : tuples) {
            // 각 튜플을 나타내는 문자열을 쉼표 ','를 기준으로 분할하여 정수형으로 변환하여 리스트에 저장
            String[] elements = tuple.split(",");
            for (String element : elements) {
                int num = Integer.parseInt(element);
                // 현재 튜플과 answerList의 원소들을 비교하여 새로운 원소가 있는지 확인
                if (!answerList.contains(num)) {
                    // 새로운 원소이면 answerList에 추가
                    answerList.add(num);
                    break;
                }
            }
        }

        // List를 배열로 변환하여 반환
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}