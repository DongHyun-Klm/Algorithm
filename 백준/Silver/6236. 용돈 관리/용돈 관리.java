import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), max = 0;
        int[] con = new int[N];
        for (int i = 0; i < N; i++) {
            con[i] = sc.nextInt();
            max = Math.max(max, con[i]);
        }
        int left = max, right = 2000000000;
        while (left <= right){
            int mid = (left + right) / 2;
            int count = 1, wallet = mid;
            for (int i = 0; i < N; i++) {
                if(wallet < con[i]){
                    count++;
                    wallet = mid;
                }
                wallet -= con[i];
            }
            if(count<=M) right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left);
    }
}