import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s, pat;
    static int[] table;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int cnt = 0;
        ArrayList<Integer> al = new ArrayList<>();
        // KMP 알고리즘
        makeTable();

        int sLen = s.length();
        int pLen = pat.length();
        int point1 = 0;
        for (int point2 = 0; point2 < sLen; point2++) {

            while (point1 > 0 && pat.charAt(point1) != s.charAt(point2)) {
                point1 = table[point1-1];
            }

            if(pat.charAt(point1) == s.charAt(point2)) {
                if(point1 == pLen-1) {
                    cnt++;
                    al.add(point2-pLen+2);
                    point1 = table[point1];
                }
                else point1++;
            }
        }
        sb.append(cnt).append('\n');
        for(int t : al) sb.append(t).append(' ');
        System.out.print(sb);
    }

    private static void makeTable() {
        int len = pat.length();
        table = new int[len];

        int point1 = 0;
        for (int point2 = 1; point2 < len; point2++) {

            while (point1 > 0 && pat.charAt(point1) != pat.charAt(point2)) {
                point1 = table[point1-1];
            }

            if(pat.charAt(point1) == pat.charAt(point2)) {
                table[point2] = ++point1;
            }
        }
    }

    private static void input() throws IOException {
        s = br.readLine();
        pat = br.readLine();
    }
}