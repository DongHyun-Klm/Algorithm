import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int rank = 1;
        int[][] medal = new int[N][4];
        for (int i=0; i<N; i++){
            for(int j=0; j<4; j++) medal[i][j] = sc.nextInt();
        }
        Arrays.sort(medal, (a , b) -> {
            if(a[1]!=b[1]) return b[1]-a[1];
            if(a[2]!=b[2]) return b[2]-a[2];
            return b[3]-a[3];
        });

        for (int i=1; i<K; i++){
            if(medal[i][1] == medal[i-1][1] && medal[i][2] == medal[i-1][2] && medal[i][3] == medal[i-1][3]) continue;
            rank++;
        }
        System.out.println(rank);
    }
}