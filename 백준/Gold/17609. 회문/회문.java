import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] arr;
    static boolean pseudo, palindrome;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            pseudo = false;
            palindrome = false;
            arr = br.readLine().toCharArray();
            int point1 = 0, point2 = arr.length-1;
            chkPalin(point1, point2, false);


            if(palindrome) sb.append(0).append('\n');
            else if(pseudo) sb.append(1).append('\n');
            else sb.append(2).append('\n');
        }
        System.out.print(sb);
    }

    private static void chkPalin(int point1, int point2, boolean flag) {
        while (point1 < point2) {
            if(arr[point1] == arr[point2]) {
                point1++;
                point2--;
            }
            else {
                if(flag) return;

                if(arr[point1 + 1] == arr[point2]) chkPalin(point1 + 1, point2, true);
                if(arr[point2 - 1] == arr[point1]) chkPalin(point1, point2 - 1, true);
                return;
            }
        }
        if(flag) pseudo = true;
        else palindrome = true;
    }

    private static void input() throws IOException {
    }
}