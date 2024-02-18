import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        quad(0,0,n);
        System.out.print(sb);
    }

    private static void quad(int r, int c, int n) {
        boolean now = arr[r][c];
        boolean flag = true;
        o: for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if(arr[i][j] != now) {
                    flag = false;
                    break o;
                }
            }
        }
        if(flag) {
            if(now) sb.append('1');
            else sb.append('0');
            return;
        }
        sb.append('(');
        quad(r,c,n/2);
        quad(r,c+n/2,n/2);
        quad(r+n/2,c,n/2);
        quad(r+n/2,c+n/2,n/2);
        sb.append(')');
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                arr[i][j] = temp[j] == '1' ? true : false;
            }
        }
    }
}