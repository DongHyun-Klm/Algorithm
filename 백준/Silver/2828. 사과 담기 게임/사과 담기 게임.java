import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0, position = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] >= position && position + M >= arr[i]) continue;
            if(arr[i] < position + M) {
                answer += position - arr[i];
                position = arr[i];
            }
            else {
                answer += arr[i] - (position + M);
                position = arr[i] - M;
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()) - 1;
        int J = Integer.parseInt(br.readLine());
        arr = new int[J];
        for (int i = 0; i < J; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}