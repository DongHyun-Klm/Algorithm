class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0; i<n; i++) {
            if(visit[i]) continue;
            DFS(i, n, computers);
            answer++;
        }
        return answer;
    }
    private static void DFS(int v, int n, int[][] computers) {
        visit[v] = true;
        
            for(int j=0; j<n; j++) {
                if(v==j) continue;
                if(visit[j]) continue;
                if(computers[v][j]==0) continue;
                DFS(j, n, computers);
            }
        
    }
}