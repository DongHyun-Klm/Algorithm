import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr1, arr2;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int point1 = 0, point2 = 0;
        while (point1 != N || point2 != M)
        {
            if(point1 != N && (point2 == M || arr1[point1] < arr2[point2])) {
                sb.append(arr1[point1++]).append(' ');
            }
            else sb.append(arr2[point2++]).append(' ');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr1 = new int[N];
        M = Integer.parseInt(st.nextToken());
        arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }
    }
}