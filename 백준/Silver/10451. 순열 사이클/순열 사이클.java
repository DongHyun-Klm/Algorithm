import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt(), ans = 0;
            boolean[] chk = new boolean[N+1];
            arr = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) {
                arr[i] = new ArrayList<>();
            }
            for (int i = 1; i <= N; i++) {
                arr[i].add(sc.nextInt());
            }
            for (int i = 1; i <= N; i++) {
                if(chk[i]) continue;
                ans++;
                DFS(i, chk);
            }
            System.out.println(ans);
        }
    }

    private static void DFS(int i, boolean[] chk) {
        if(chk[i]) return;
        chk[i] = true;
        DFS(arr[i].get(0), chk);
    }
}