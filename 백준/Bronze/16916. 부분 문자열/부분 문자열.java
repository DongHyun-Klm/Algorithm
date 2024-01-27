import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s, bomb;
    static int[] table;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        makeTable(bomb);
        int sLen = s.length();
        int pLen = bomb.length();
        boolean flag = true;

        int point1 = 0;
        for (int point2 = 0; point2 < sLen; point2++) {
            while (point1 > 0 && bomb.charAt(point1) != s.charAt(point2)) {
                point1 = table[point1-1];
            }

            if(bomb.charAt(point1) == s.charAt(point2)) {
                if(point1 == pLen - 1) {
                    System.out.println(1);
                    flag = false;
                    break;
                }
                else point1++;
            }
        }
        if(flag) System.out.println(0);
    }

    private static void makeTable(String bomb) {
        int pLen = bomb.length();
        table = new int[pLen];

        int point1 = 0;
        for (int point2 = 1; point2 < pLen; point2++) {
            while (point1 > 0 && bomb.charAt(point1) != bomb.charAt(point2)) {
                point1 = table[point1-1];
            }

            if(bomb.charAt(point1) == bomb.charAt(point2)) {
                table[point2] = ++point1;
            }
        }
    }

    private static void input() throws IOException {
        s = br.readLine();
        bomb = br.readLine();
    }
}