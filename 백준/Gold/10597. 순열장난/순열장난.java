import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;
    static boolean[] chk;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        input();
        char[] arr = s.toCharArray();
        int N;
        // 1~9
        if(arr.length < 10) N = arr.length;
        // 10~50
        else N = 9 + (arr.length-9) / 2;
        int[] retrace = new int[N];
        chk = new boolean[N + 1];
        chk[0] = true;
        BT(0, 0, N, arr, retrace);
    }

    private static void BT(int d, int index, int N, char[] arr, int[] retrace) {
        if(flag) return;
        if(d == N) {
            for (int i = 0; i < retrace.length; i++) {
                sb.append(retrace[i]).append(' ');
            }
            System.out.print(sb);
            flag = true;
            return;
        }

        // 숫자 하나 사용
        int num = arr[index] - '0';
        if(num <= N && !chk[num]) {
            retrace[d] = num;
            chk[num] = true;
            BT(d+1, index+1, N, arr, retrace);
            retrace[d] = 0;
            chk[num] = false;
        }
        // 숫자 두개 사용
        if(index+1 == arr.length) return;
        String temp = arr[index] + "" + arr[index+1];
        num = Integer.parseInt(temp);
        if(num <= N && !chk[num]) {
            retrace[d] = num;
            chk[num] = true;
            BT(d+1, index + 2, N, arr, retrace);
            retrace[d] = 0;
            chk[num] = false;
        }
    }

    private static void input() throws IOException {
        s = br.readLine();
    }
}