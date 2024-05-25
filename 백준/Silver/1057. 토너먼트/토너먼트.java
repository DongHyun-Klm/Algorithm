import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, n1, n2;

    public static void main(String[] args) throws Exception{
        input();
        int answer = 0;
        while (n1 != n2) {
            n1 = (n1 + 1) / 2;
            n2 = (n2 + 1) / 2;
            answer++;
        }
        System.out.println(answer);
    }

    private static void input() throws Exception{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        n1 = Integer.parseInt(st.nextToken());
        n2 = Integer.parseInt(st.nextToken());
    }
}