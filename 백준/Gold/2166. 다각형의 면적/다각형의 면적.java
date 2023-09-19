import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] x = new long[N+1], y = new long[N+1];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        x[N] = x[0];
        y[N] = y[0];
        double area = 0, sum1 = 0, sum2 = 0;
        for (int i = 0; i < N; i++) {
            sum1 += x[i] * y[i+1];
            sum2 += x[i+1] * y[i];
        }
        area = Math.abs(sum1 - sum2) / 2;
        System.out.println(String.format("%.1f", area));
    }
}