import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static BigInteger answer = BigInteger.ONE;
    static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        BT(n, m);
        while (!q.isEmpty()){
            answer = answer.divide(BigInteger.valueOf(q.poll()));
        }
        System.out.println(answer);
    }

    private static void BT(int n, int m) {
        if(m==0) return;
        answer = answer.multiply(BigInteger.valueOf(n));
        q.add(m);
        BT(n-1, m-1);
    }
}