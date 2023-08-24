import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt(), y1 = sc.nextInt(), r1 = sc.nextInt(), x2 = sc.nextInt(), y2 = sc.nextInt(), r2 = sc.nextInt();
            double r = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
            if(r == 0 && r1 == r2) sb.append(-1).append('\n');
            else if(r == r1 + r2 || r + r1 == r2 || r + r2 == r1) sb.append(1).append('\n');
            else if(r > r1 + r2 || r1 > r + r2 || r2 > r + r1) sb.append(0).append('\n');
            else sb.append(2).append('\n');
        }
        System.out.print(sb);
    }
}