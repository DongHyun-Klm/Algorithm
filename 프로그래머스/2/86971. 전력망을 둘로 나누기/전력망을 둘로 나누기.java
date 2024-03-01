import java.util.*;

class Solution {
    static ArrayList<Integer>[] al;
    static int answer = 100;
    static int cnt = 0;
    public int solution(int n, int[][] wires) {
        al = new ArrayList[n+1];
        for(int i=1; i<=n; i++) al[i] = new ArrayList<>();
        for(int i=0; i<wires.length; i++) {
            al[wires[i][0]].add(wires[i][1]);
            al[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0; i<wires.length; i++) {
            boolean[] visit = new boolean[n+1];
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j=1; j<=n; j++) {
                if(visit[j]) continue;
                cnt = 0;
                DFS(i, j, visit, wires);
                temp.add(cnt);
            }
            answer = Math.min(answer, Math.abs(temp.get(1) - temp.get(0)));
        }
        return answer;
    }
    private void DFS(int i, int v, boolean[] visit, int[][] wires) {
        cnt++;
        visit[v] = true;
        for(int t : al[v]) {
            if(visit[t]) continue;
            if(wires[i][0] == v && wires[i][1] == t) continue;
            if(wires[i][0] == t && wires[i][1] == v) continue;
            DFS(i, t, visit, wires);
        }
    }
}