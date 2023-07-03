import java.util.*;
import java.io.*;

class Solution {
    // 간선 정보 담을 info 구현
    static ArrayList<info>[] arr;
    static class info implements Comparable<info>{
        int v, w;
        info(int v, int w){
            this.v = v;
            this.w = w;
        }
        
        public int compareTo(info o){
            return w - o.w;
        }
    }
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 인접 리스트
        arr = new ArrayList[n+1];
        for(int i=1;i<=n;i++) arr[i] = new ArrayList<>();
        for(int i=0;i<fares.length;i++){
            int x = fares[i][0];
            int y = fares[i][1];
            int w = fares[i][2];
            arr[x].add(new info(y, w));
            arr[y].add(new info(x, w));
        }
        
        // 최단 거리 담을 dist배열
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];
        int[] dist3 = new int[n+1];
        Arrays.fill(dist1, 2000000000);
        Arrays.fill(dist2, 2000000000);
        Arrays.fill(dist3, 2000000000);
        // 세 노드에서 각 노드에 대한 최단비용 구하기
        dijkstra(s, dist1);
        dijkstra(a, dist2);
        dijkstra(b, dist3);
        
        int answer = Integer.MAX_VALUE;
        for(int i =1; i<=n; i++){
            answer = Math.min(answer, dist1[i] + dist2[i] + dist3[i]);
        }
        return answer;
    }
    static void dijkstra(int start, int[] d){
        // 우선순위큐로 다익스트라 구현
        PriorityQueue<info> q = new PriorityQueue<>();
        boolean[] visited = new boolean[d.length+1];
        d[start] = 0;
        q.add(new info(start, 0));
        while(!q.isEmpty()){
            info now = q.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;
            for(info f : arr[now.v]){
                if(d[f.v] > f.w + d[now.v]){
                    d[f.v] = f.w + d[now.v];
                    q.add(new info(f.v, d[f.v]));
                }
            }
        }
    }
}