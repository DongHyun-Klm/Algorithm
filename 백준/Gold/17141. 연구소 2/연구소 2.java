import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = 2000000000;
    static int[][] arr, select, dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    static ArrayList<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        arr = new int[N][N];
        select = new int[M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2) list.add(new int[] {i, j});
            }
        }
        BT(0, M, 0);
        if(min == 2000000000) min = -1;
        System.out.println(min);
    }

    private static void BT(int d, int M, int start) {
        if(d==M){
            int[][] arr_copy = new int[arr. length][arr.length];
            for(int i=0; i< arr.length; i++) arr_copy[i] = arr[i].clone();
            BFS(arr_copy, select);
            return;
        }
        for (int i = start; i < list.size(); i++) {
            select[d] = list.get(i);
            BT(d+1, M, i+1);
        }
    }

    private static void BFS(int[][] arrCopy, int[][] select) {
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arrCopy[i][j] == 1) arrCopy[i][j] = -1;
                if(arrCopy[i][j] == 2) arrCopy[i][j] = 0;
            }
        }
        for (int i = 0; i < select.length; i++) {
            q.add(select[i]);
            arrCopy[select[i][0]][select[i][1]] = 1;
        }
        int max = 0;
        boolean flag = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int r = now[0], c = now[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dir[i][0], nc = c + dir[i][1];
                if(nr<0 || nc<0 || nr >= arr.length || nc >= arr.length) continue;
                if(arrCopy[nr][nc] == 0) {
                    arrCopy[nr][nc] = arrCopy[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arrCopy[i][j] == 0) flag = false;
                max = Math.max(max, arrCopy[i][j]);
            }
        }
        if(flag) min = Math.min(min, max - 1);
    }
}