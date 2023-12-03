import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long gcd;
            if(a > b) gcd = GCD(a,b);
            else gcd = GCD(b,a);
            System.out.println((long)a * b / gcd);
        }
    }

    private static int GCD(int big, int small){
        if(big % small == 0) return small;
        return GCD(small, big % small);
    }
}