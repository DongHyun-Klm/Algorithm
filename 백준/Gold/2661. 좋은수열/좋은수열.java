import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<String> s = new HashSet<>();
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        BT(0, N);
    }

    private static void BT(int d, int N) {
        // 가장 작은 수를 찾았으면 나머지 리턴
        if(flag) return;
        // 좋은 수열인지 검사
        char[] arr = sb.toString().toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int len = 1; i + len*2 <= arr.length; len++) {
                boolean chk = true;
                for (int j = 0; j < len; j++) {
                    if(arr[i+j] != arr[i+len+j]) chk = false;
                }
                if(chk) return;
            }
        }

        if(sb.length() == N) {
            System.out.print(sb);
            flag = true;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            sb.append(i);
            BT(d+1, N);
            sb.delete(d, d+1);
        }
    }
}