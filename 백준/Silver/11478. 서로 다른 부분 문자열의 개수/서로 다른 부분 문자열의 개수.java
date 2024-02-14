import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;

    public static void main(String[] args) throws IOException {
        input();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                set.add(s.substring(i, j));
            }
        }
        System.out.println(set.size());
    }

    private static void input() throws IOException {
        s = br.readLine();
    }
}