import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++) {
            ArrayList<Integer> al = new ArrayList<>();
            for(int j=commands[i][0] - 1; j<commands[i][1]; j++) {
                al.add(array[j]);
            }
            Collections.sort(al);
            answer[i] = al.get(commands[i][2] - 1);
        }
        return answer;
    }
}