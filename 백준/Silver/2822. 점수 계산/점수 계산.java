import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] score = new int[8][2];
        int[] rank = new int[5];
        int total = 0;
        for (int i = 0; i < 8; i++) {
            score[i][0] = sc.nextInt();
            score[i][1] = i+1;
        }
        Arrays.sort(score, (a,b) -> {
            return b[0] - a[0];
        });
        for (int i = 0; i < 5; i++) {
            total += score[i][0];
            rank[i] = score[i][1];
        }
        System.out.println(total);
        Arrays.sort(rank);
        for (int i = 0; i < 5; i++) {
            System.out.print(rank[i] + " ");
        }
    }
}