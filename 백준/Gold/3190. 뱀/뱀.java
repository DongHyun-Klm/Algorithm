import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[][] arr, dir = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void main(String[] args) throws IOException {
        input();
        int L = Integer.parseInt(br.readLine());
        int time = 0, d = 0, r = 0, c = 0, tail_r = 0, tail_c = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Character> m = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            m.put(X, C);
        }

        for (int j = time; j < 11000; j++) {
            time++;
            r += dir[d][0];
            c += dir[d][1];
            if(r<0||c<0||r>=N||c>=N||arr[r][c]==1) {
                System.out.println(time);
                return;
            }

            q.add(d);
            if(arr[r][c]==0) {
                arr[r][c] = 1;
                arr[tail_r][tail_c] = 0;
                int tail_d = -1;
                tail_d = q.poll();
                tail_r += dir[tail_d][0];
                tail_c += dir[tail_d][1];
            }
            arr[r][c] = 1; 
            if(m.containsKey(time)) {
                if(m.get(time) == 'D') {
                    d++;
                    d%=4;
                }
                else {
                    d+=3;
                    d%=4;
                }
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        arr[0][0] = 1;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            arr[r][c] = 2;
        }
    }
}