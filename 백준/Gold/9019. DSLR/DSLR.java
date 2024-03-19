import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, A, B;
    static class info {
        int num;
        String command;

        public info(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-->0) {
            input();
            BFS();
        }
        System.out.print(sb);
    }

    private static void BFS() {
        Queue<info> q = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        q.add(new info(A, ""));
        s.add(A);
        while (!q.isEmpty()) {
            info now = q.poll();
            // D
            int D = (now.num * 2) % 10000;
            if(D == B) {
                sb.append(now.command).append('D').append('\n');
                return;
            }
            if(!s.contains(D)) {
                s.add(D);
                q.add(new info(D, now.command+ "D"));
            }
            // S
            int S = now.num - 1;
            if(S == -1) S = 9999;
            if(S == B) {
                sb.append(now.command).append('S').append('\n');
                return;
            }
            if(!s.contains(S)) {
                s.add(S);
                q.add(new info(S, now.command + "S"));
            }
            // L R
            char[] arr = new char[4];
            char[] num_char = Integer.toString(now.num).toCharArray();
            Arrays.fill(arr, '0');
            int index = num_char.length - 1, index2 = 3;
            while (index >= 0) {
                arr[index2--] = num_char[index--];
            }

            StringBuilder LS = new StringBuilder(), RS = new StringBuilder();
            for (int i = 1; i < 4; i++) {
                LS.append(arr[i]);
            }
            LS.append(arr[0]);
            int L = Integer.parseInt(LS.toString());
            RS.append(arr[3]);
            for (int i = 0; i < 3; i++) {
                RS.append(arr[i]);
            }
            int R = Integer.parseInt(RS.toString());
            if(L == B) {
                sb.append(now.command).append('L').append('\n');
                return;
            }
            if(R == B) {
                sb.append(now.command).append('R').append('\n');
                return;
            }
            if (!s.contains(L)) {
                s.add(L);
                q.add(new info(L, now.command + "L"));
            }
            if (!s.contains(R)) {
                s.add(R);
                q.add(new info(R, now.command + "R"));
            }
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }
}