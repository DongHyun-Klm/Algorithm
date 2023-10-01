import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        Map<Integer, Character> map = new HashMap<>();
        int[] seq = new int[26];
        int step = 1;
        for(int i=0; i<26; i++){
            char now = (char)(i+97);
            if(!skip.contains(now+ "")) {
                seq[i] = step;
                map.put(step++, now);
            }
        }
        System.out.println(map);
        System.out.println(Arrays.toString(seq));
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            answer += map.get((seq[arr[i] - 97] + index - 1) % map.size() + 1);
        }
        return answer;
    }
}