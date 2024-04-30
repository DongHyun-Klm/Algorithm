import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] T, P;

    public static void main(String[] args) throws IOException {
        input();
        Set<String> s = new HashSet<>();
        while (N-- > 0) {
            char[] arr = br.readLine().toCharArray();
            Arrays.sort(arr);
            sb.setLength(0);
            for(char c : arr) sb.append(c);
            if(!s.contains(sb.toString())) s.add(sb.toString());
        }
        System.out.print(s.size());
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}