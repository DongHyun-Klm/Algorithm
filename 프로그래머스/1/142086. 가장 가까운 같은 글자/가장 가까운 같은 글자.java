import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] loc = new int[26];
        char[] arr = s.toCharArray();
        int[] answer = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            if(loc[arr[i] - 97] == 0) answer[i] = -1;
            else answer[i] = i - loc[arr[i] - 97] + 1;
            loc[arr[i] - 97] = i+1;
        }
        
        return answer;
    }
}