import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0, answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        ArrayList<Integer> al = new ArrayList<>(map.values());
        Collections.sort(al, (a,b) -> b - a);
        for (int v : al) {
            if (sum + v >= k) {
                answer++;
                break;
            } else {
                sum += v;
                answer++;
            }
        }
        return answer;
    }
}