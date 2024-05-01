import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            int x = Integer.parseInt(s) * 10000000;
            int n = Integer.parseInt(br.readLine());
            int max = -1, left = -1, right = -1;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            int point1 = 0, point2 = n-1;
            while(point1 < point2) {
                int sum = arr[point1] + arr[point2];
                if(sum == x) {
                    if(max < arr[point2] - arr[point1]) {
                        left = arr[point1];
                        right = arr[point2];
                        max = arr[point2] - arr[point1];
                    }
                    point1++;
                }
                else if(sum > x) point2--;
                else point1++;
            }
            if(max == -1) sb.append("danger").append('\n');
            else sb.append("yes ").append(left).append(' ').append(right).append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
    }
}