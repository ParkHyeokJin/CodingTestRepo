import java.util.*;
class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        List<List<String>> allSetList = new ArrayList<>();
        for(String order : orders){
            List<String> setList = new ArrayList<>();
            for(int c : course) {
                char[] charArray = order.toCharArray();
                Arrays.sort(charArray);
                getOrderCase(String.valueOf(charArray), 0, "", c, setList);
            }
            allSetList.add(setList);
        }

        Map<Integer, Map<String, Integer>> menuRank = new HashMap<>();
        for(int c : course){
            menuRank.put(c, new HashMap<>());
        }

        for(List<String> setMenu : allSetList){
            for(String menu : setMenu){
                menuRank.get(menu.length()).put(menu, menuRank.get(menu.length()).getOrDefault(menu, 0) + 1);
            }
        }

        List<String> answers = new ArrayList<>();
        for(int c : course){
            List<Map.Entry<String, Integer>> list = new ArrayList<>(menuRank.get(c).entrySet());
            list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            int maxCnt = Integer.MIN_VALUE;
            for(Map.Entry<String, Integer> map : list){
                if(map.getValue() < maxCnt || map.getValue() < 2){
                    break;
                }
                answers.add(map.getKey());
                maxCnt = map.getValue();
            }
        }

        Collections.sort(answers);
        return answers.toArray(new String[0]);
    }

    private void getOrderCase(String order, int idx, String setMenu, int course, List<String> setList) {
        if(setMenu.length() == course){
            setList.add(setMenu);
            return;
        }
        for(int i = idx; i < order.length(); i++){
            getOrderCase(order, i+1, setMenu + order.charAt(i), course, setList);
        }
    }
}