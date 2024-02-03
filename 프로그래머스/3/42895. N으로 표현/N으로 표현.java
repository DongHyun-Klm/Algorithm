import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        Set<Integer>[] s = new HashSet[9];
        for(int i=0; i<9; i++) s[i] =  new HashSet<>();
        String num = "";
        for(int i=1; i<9; i++) {
            num += N;
            s[i].add(Integer.parseInt(num));
            for(int j=1; j<i; j++) {
                int k = i - j;
                for(int t1 : s[j]) {
                    for(int t2 : s[k]) {
                        s[i].add(t1 + t2);
                        s[i].add(t1 - t2);
                        s[i].add(t1 * t2);
                        if(t2 != 0)s[i].add(t1 / t2);
                    }
                }
            }
            
            if(s[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}