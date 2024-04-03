import java.util.*;

class Solution {
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static Map<String, Integer> dir = new HashMap<>();
    static int order = 0;
    public int solution(String word) {
        rec("", word, 0);
        return dir.get(word);
    }
    
    private void rec(String now, String word, int d) {
        dir.put(now, order++);
        if(d==5) {
            return;
        }
        for(int i=0; i<5; i++) {
            rec(now + arr[i], word, d+1);
        }
    }
}