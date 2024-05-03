import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int X, Y;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        long Z = ((long)Y * 100) / X;
        int left = 1, right = 1000000000, answer = -1;
        if(((right + (long)Y) * 100) / (right + X) != Z)
        {
            while (left <= right) {
                int mid = (left + right) / 2;
                long z = ((mid + (long)Y) * 100) / (mid + X);
                if(z==Z) {
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                    answer = mid;
                }
            }
        }
        System.out.print(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}