import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<int[]>[] al = new ArrayList[n];
        for(int i=0; i<n; i++) al[i] = new ArrayList<>();
        for(int i=0; i<costs.length; i++) {
            al[costs[i][0]].add(new int[] {costs[i][1], costs[i][2]});
            al[costs[i][1]].add(new int[] {costs[i][0], costs[i][2]});
        }
        for(int i=0; i<n; i++) Collections.sort(al[i], (a,b) -> a[1] - b[1]);
        boolean[] visit = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[] {0,0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(visit[now[0]]) continue;
            visit[now[0]] = true;
            answer += now[1];
            for(int[] t : al[now[0]]) {
                if(visit[t[0]]) continue;
                pq.add(t);
            }
        }
        return answer;
    }
}