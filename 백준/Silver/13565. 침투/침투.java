

import java.util.*;

public class Main {
    static int M, N;
    static boolean[][] visited;
    static int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt(); N = sc.nextInt();
        boolean[][] arr = new boolean[M][N];
        visited = new boolean[M][N];
        for(int i=0;i<M;i++){
            char[] s = sc.next().toCharArray();
            for(int j=0;j<N;j++){
                if(s[j]=='1') arr[i][j] = true;
            }
        }
        for(int i=0;i<N;i++){
            if(!arr[M-1][i]){
                for(int q=0; q<M;q++)Arrays.fill(visited[q],false);
                rec(M-1, i, arr);
                if(flag){
                    System.out.println("YES");
                    break;
                }
            }
            if(i==N-1) System.out.println("NO");
        }
    }
    static void rec(int r, int c, boolean[][] arr){
        if(r==0){
            flag = true;
            return;
        }
        visited[r][c] = true;
        for(int k = 0;k<4;k++){
            int nr = r + dir[k][0];
            int nc = c + dir[k][1];
            if(nr<0||nc<0||nr>=M||nc>=N) continue;
            if(arr[nr][nc]) continue;
            if(visited[nr][nc]) continue;
            rec(nr, nc, arr);
        }
    }
}