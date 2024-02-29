import java.util.*;

class Solution {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public int solution(int[][] maps) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        q.add(new int[] {0,0,1});
        while(!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++) {
                int nr = now[0] + dir[i][0];
                int nc = now[1] + dir[i][1];
                if(nr>=maps.length || nc>=maps[0].length || nr<0 || nc<0) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;
                if(nr == maps.length - 1 && nc == maps[0].length - 1) return now[2] + 1;
                q.add(new int[] {nr, nc, now[2] + 1});
                visited[nr][nc] = true;
            }
            
        }
        
        return -1;
    }
}