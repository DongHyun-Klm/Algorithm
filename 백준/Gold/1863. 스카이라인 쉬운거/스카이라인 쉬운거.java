import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] altitude = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            altitude[i][0] = Integer.parseInt(st.nextToken());
            altitude[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(altitude, (a,b) -> a[0] - b[0]);

        int answer = 0;
        // x좌표 기준 거꾸로가면서
        // 높이가 높아지면 + 1
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for (int i = 0; i < n ; i++) {
            if(altitude[i][1] == 0){
                pq.clear();
                continue;
            }
            if(pq.isEmpty()) {
                pq.add(altitude[i][1]);
                answer++;
                continue;
            }
            if(altitude[i][1] >= pq.peek()) {
                pq.add(altitude[i][1]);
                answer++;
            }
            else {
                while (!pq.isEmpty() && pq.peek() > altitude[i][1]) pq.poll();
                if(!pq.isEmpty() && pq.peek() == altitude[i][1]) {
                    continue;
                }
                pq.add(altitude[i][1]);
                answer++;
            }
        }
        System.out.println(answer);
    }
}