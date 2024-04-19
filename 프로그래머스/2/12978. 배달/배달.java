import java.util.*;

class Solution {
    static ArrayList<int[]>[] al;
    static int INF = 2000000000;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        al = new ArrayList[N+1];
        for(int i=1; i<=N; i++) al[i] = new ArrayList<>();
        for(int i=0; i<road.length; i++) {
            al[road[i][0]].add(new int[] {road[i][1], road[i][2]});
            al[road[i][1]].add(new int[] {road[i][0], road[i][2]});
        }
        int[] dist = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        Arrays.fill(dist, INF);
        dist[1] = 0;
        pq.add(new int[] {1,0});
        while(!pq.isEmpty()) {
            int[] now = pq.poll();
            if(dist[now[0]] < now[1]) continue;
            for(int[] t : al[now[0]]) {
                if(dist[t[0]] > now[1] + t[1]) {
                    dist[t[0]] = now[1] + t[1];
                    pq.add(new int[] {t[0], dist[t[0]]});
                }
            }
        }
        for(int i=1; i<=N; i++) {
            if(dist[i] <= K) answer++;
        }
        
        return answer;
    }
}