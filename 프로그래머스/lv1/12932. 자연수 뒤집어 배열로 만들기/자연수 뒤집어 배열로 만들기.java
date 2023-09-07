import java.util.*;

class Solution {
    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int[] answer = new int[sb.toString().length()];
        long r = Long.parseLong(sb.toString());
        for(int i=0; i<answer.length; i++){
            answer[i] = (int)(r % 10);
            r /= 10;
        }
        return answer;
        // StringBuilder 안써도 된다..
    }
}