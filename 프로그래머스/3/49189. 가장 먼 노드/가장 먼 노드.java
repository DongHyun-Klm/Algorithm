import java.util.*;

class Solution {
    static ArrayList<Integer>[] al;
    static int max = -1, answer = 0;
    static boolean[] visit;
    public int solution(int n, int[][] edge) {
        al = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n; i++) al[i] = new ArrayList<>();    
        for(int i=0; i<edge.length; i++) {
            al[edge[i][0]].add(edge[i][1]);
            al[edge[i][1]].add(edge[i][0]);
        }
        BFS();
        return answer;
    }
    static private void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1,0});
        visit[1] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            if(now[1] > max) {
                max = now[1];
                answer= 1;
            }
            else if(now[1] == max) answer++;
            for(int t : al[now[0]]) {
                if(visit[t]) continue;
                q.add(new int[] {t,now[1] + 1});
                visit[t] = true;
            }
        } 
    }
}