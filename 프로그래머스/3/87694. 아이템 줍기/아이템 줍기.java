import java.util.*;

class Solution {
    static int[][] arr;
    static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static class info {
        int r, c, dist;
        public info(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        arr = new int[101][101];
        for(int k=0; k<rectangle.length; k++) {
            int c = rectangle[k][0] * 2, r = rectangle[k][1] * 2;
            for(int i = c; i <= rectangle[k][2] * 2; i++) {
                for(int j = r; j <= rectangle[k][3] * 2; j++) {
                    if(arr[j][i] == 2) continue;
                    if(i == c || i == rectangle[k][2] * 2 || j == r || j == rectangle[k][3] * 2) {
                        arr[j][i] = 1;
                    }
                    else arr[j][i] = 2;
                }
            }
        }
        answer = BFS(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
        return answer;
    }
    private int BFS(int x, int y, int itemX, int itemY) {
        Queue<info> q = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        q.add(new info(y,x,0));
        while(!q.isEmpty()) {
            info now = q.poll();
            for(int i = 0; i < 4 ; i++) {
                int nr = now.r + dir[i][0];
                int nc = now.c + dir[i][1];
                if(nr>100 || nc>100 || nr<0 || nc<0) continue;
                if(visited[nr][nc]) continue;
                if(!(arr[nr][nc]==1)) continue;
                if(nc == itemX && nr == itemY) return (now.dist + 1) / 2;
                visited[nr][nc] = true;
                q.add(new info(nr, nc, now.dist+1));
            }
        }
        return -1;
    }
}