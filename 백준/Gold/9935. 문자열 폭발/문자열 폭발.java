import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String s, pat;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        int pLen = pat.length();
        char[] arr = s.toCharArray();
        Stack<Character> stk = new Stack<>();
        Stack<Character> temp = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stk.add(arr[i]);

            if(stk.size() < pLen) continue;
            if(stk.peek() != pat.charAt(pLen-1)) continue;
            boolean flag = true;
            for (int j = 0; j < pLen; j++) {
                if(stk.get(stk.size() - pLen + j) != pat.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                for (int j = 0; j < pLen; j++) stk.pop();
            }
        }
        if(stk.isEmpty()) System.out.println("FRULA");
        else {
            while (!stk.isEmpty()) sb.append(stk.pop());
            System.out.println(sb.reverse());
        }
    }

    private static void input() throws IOException {
        s = br.readLine();
        pat = br.readLine();
    }
}