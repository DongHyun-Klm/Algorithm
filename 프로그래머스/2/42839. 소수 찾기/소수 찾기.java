import java.util.*;

class Solution {
    static char[] arr;
    static Set<Integer> s;
    static boolean[] visited;
    public int solution(String numbers) {
        arr = numbers.toCharArray();
        visited = new boolean[arr.length];
        int answer = 0;
        s = new HashSet<>();
        BT("", 0);
        for(int t : s) {
            if(t < 2) continue;
            if(t == 2 || t == 3) {
                answer++;
                continue;
            }
            int count = 0;
            for(int i = 2; i <= Math.sqrt(t); i++) {
                if(t % i == 0) {
                    count++;
                    break;
                }
            }
            if(count == 0) answer++;
        }
        return answer;
    }
    private void BT(String number, int d) {
        if(d == arr.length) return;
        for(int i=0; i<arr.length; i++) {
            if(visited[i]) continue;
            s.add(Integer.parseInt(number + arr[i]));
            visited[i] = true;
            BT(number + arr[i], d+1);
            visited[i] = false;
        }
    }
}