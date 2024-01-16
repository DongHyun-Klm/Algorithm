import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        if(N==1) System.out.println("A");
        else if(N==2) {
            if(arr[0] == arr[1]) System.out.println(arr[0]);
            else System.out.println("A");
        }
        else {
            int a, b;
            if(arr[0] == arr[1]) {
                a = 1;
                b = 0;
            }
            else {
                a = (arr[1] - arr[2]) / (arr[0] - arr[1]);
                b = arr[1] - arr[0] * a;
            }
            boolean flag = true;
            for (int i = 0; i < N-1; i++) {
                int temp = a * arr[i] + b;
                if(temp != arr[i+1]) {
                    flag = false;
                    System.out.println("B");
                    break;
                }
            }
            if(flag) System.out.println(arr[N-1] * a + b);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}