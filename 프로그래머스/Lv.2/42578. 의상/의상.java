import java.util.*;

class Solution {
    static int answer = 1;
    static Map<String, Integer> m;
    public int solution(String[][] clothes) {
        m = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            m.put(clothes[i][1], m.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(String s : m.keySet()){
            answer *= m.get(s) + 1;
        }
        return answer-1;
    }
}