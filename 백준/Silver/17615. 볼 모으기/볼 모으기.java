import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, redBall = 0, blueBall = 0;
    static boolean[] arr;

    public static void main(String[] args) throws Exception{
        input();
        int answer = Integer.MAX_VALUE;

        // 오른쪽으로 빨강공 밀기
        int count = 0;
        for (int i = N-1; i >= 0; i--) {
            if(arr[i]) break;
            else count++;
        }
        answer = Math.min(answer, redBall - count);

        // 오른쪽으로 파란공 밀기
        count = 0;
        for (int i = N-1; i >= 0; i--) {
            if(!arr[i]) break;
            else count++;
        }
        answer = Math.min(answer, blueBall - count);

        // 왼쪽으로 빨간공 밀기
        count = 0;
        for (int i = 0; i < N; i++) {
            if(arr[i]) break;
            else count++;
        }
        answer = Math.min(answer, redBall - count);

        // 왼쪽으로 파란공 밀기
        count = 0;
        for (int i = 0; i < N; i++) {
            if(!arr[i]) break;
            else count++;
        }
        answer = Math.min(answer, blueBall - count);


        System.out.print(answer);
    }

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        char[] temp = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if(temp[i] == 'B') {
                arr[i] = true;
                blueBall++;
            }
            else redBall++;
        }
    }
}