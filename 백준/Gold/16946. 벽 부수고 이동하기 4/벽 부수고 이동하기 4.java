import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] cnt = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j] - '0';
            }
        }
        // 좌표 기억용 큐
        Queue<int[]> q = new LinkedList<>();
        // 그룹으로 이동가능 칸수 기억하기
        Map<Integer, Integer> m = new HashMap<>();
        int mapNum = 1;
        // 미리 이동할 수 있는 칸 계산하기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && arr[i][j] == 0) {
                    count = 0;
                    DFS(arr, visited, q, i, j);
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        cnt[now[0]][now[1]] = mapNum;
                    }
                    m.put(mapNum++, count);
                }
            }
        }

        // 그룹기억용 set
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 1){
                    int sum = 1;
                    for (int k = 0; k < 4; k++) {
                        int nr = i + dir[k][0];
                        int nc = j + dir[k][1];
                        if(nr<0||nc<0||nr>=N||nc>=M) continue;
                        if(cnt[nr][nc]==0) continue;
                        s.add(cnt[nr][nc]);
                        sum += cnt[nr][nc];
                    }
                    for(int t : s){
                        arr[i][j] += m.get(t);
                    }
                    arr[i][j] %= 10;
                    s.clear();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void DFS(int[][] arr, boolean[][] visited, Queue q, int r, int c) {
        visited[r][c] = true;
        q.add(new int[] {r,c});
        count++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if(nr<0||nc<0||nr>= arr.length||nc>=arr[0].length) continue;
            if(visited[nr][nc]) continue;
            if(arr[nr][nc] == 0) DFS(arr, visited, q, nr, nc);
        }
    }
}