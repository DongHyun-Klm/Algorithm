import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            char[] arr = br.readLine().toCharArray();
            if(arr.length==3) break;
            char[][] temp = new char[3][3];
            int cnt1 = 0, cnt2 = 0;
            boolean flag = true;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(arr[3*i+j] == '.') continue;
                    temp[i][j] = arr[3*i+j];
                    if(temp[i][j] == 'X') cnt1++;
                    else cnt2++;
                }
            }
            // O가 더 많은경우, X가 O보다 2개이상 많은경우
            if(cnt2 > cnt1 || cnt1 - cnt2 > 1){
                flag = false;
            }
            else {
                int c = chk(temp);
                // O, X 모두 빙고인 경우
                if(c == 3) flag = false;
                // O 빙고인데 X가 더 많을경우
                else if(c==2) {
                    if(cnt1 > cnt2) flag = false;
                }
                // X 빙고인데 O와 개수가 같은경우
                else if(c==1) {
                    if(cnt1 == cnt2) flag = false;
                }
                // 빙고가 없는데 빈칸이 있는경우
                else {
                    if(cnt1 + cnt2 < 9) flag = false;
                }
            }

            if(flag) sb.append("valid").append('\n');
            else sb.append("invalid").append('\n');
        }
        System.out.print(sb);
    }

    private static int chk(char[][] temp) {
        int chk = 0;
        char[] arr = new char[] {'X', 'O'};
        for (int i = 0; i < 2; i++) {
            // 8빙고 탐색
            if(temp[0][0] == arr[i] && temp[0][1] == arr[i] && temp[0][2] == arr[i]) chk += i+1;
            else if(temp[1][0] == arr[i] && temp[1][1] == arr[i] && temp[1][2] == arr[i]) chk += i+1;
            else if(temp[2][0] == arr[i] && temp[2][1] == arr[i] && temp[2][2] == arr[i]) chk += i+1;
            else if(temp[0][0] == arr[i] && temp[1][0] == arr[i] && temp[2][0] == arr[i]) chk += i+1;
            else if(temp[0][1] == arr[i] && temp[1][1] == arr[i] && temp[2][1] == arr[i]) chk += i+1;
            else if(temp[0][2] == arr[i] && temp[1][2] == arr[i] && temp[2][2] == arr[i]) chk += i+1;
            else if(temp[0][0] == arr[i] && temp[1][1] == arr[i] && temp[2][2] == arr[i]) chk += i+1;
            else if(temp[0][2] == arr[i] && temp[1][1] == arr[i] && temp[2][0] == arr[i]) chk += i+1;
        }
        return chk;
    }

    private static void input() throws IOException {
    }
}