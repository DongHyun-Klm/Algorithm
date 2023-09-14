import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scores = new int[N];
        int[] ans = new int[1000001];
        boolean[] chk = new boolean[1000001];
        for (int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();
            chk[scores[i]] = true;
        }
        for (int i = 0; i < N; i++) {
            int now = scores[i];
            int mul = 2;
            while(now * mul <= 1000000){
                if(chk[now * mul]) {
                    ans[now]++;
                    ans[now * mul]--;
                }
                mul++;
            }
        }
        for (int i = 0; i < N; i++) {
            System.out.print(ans[scores[i]] + " ");
        }
    }
}