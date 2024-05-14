import java.util.*;

class Solution {
    static Set<Integer> s = new HashSet<>();
    public int solution(int[] elements) {
        int answer = 0;
        for(int i=1; i<= elements.length; i++) {
            BT(0, i, elements);
        }
        answer = s.size();
        return answer;
    }
    private void BT(int d, int len, int[] elements) {
        if(d==elements.length) {
            return;    
        }
        int sum = 0;
        for(int i=d; i<d+len; i++) {
            int index = i;
            if(i >= elements.length) index = i % elements.length;
            sum += elements[index];
        }
        s.add(sum);
        BT(d+1, len, elements);
    }
}