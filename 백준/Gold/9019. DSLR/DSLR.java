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
            int L = ((now.num%1000)*10) + (now.num/1000);
            int R = (now.num/10)+ (now.num%10)*1000;
            
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