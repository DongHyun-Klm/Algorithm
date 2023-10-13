import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), P = sc.nextInt(), sum;
        Deque<Integer> q = new LinkedList<>();
        q.add(A);
        while (true){
            sum = 0;
            while (A != 0) {
                sum += (int) Math.pow((A % 10), P);
                A /= 10;
            }
            if(q.contains(sum)) {
                while (q.peekLast()!=sum){
                    q.pollLast();
                }
                System.out.println(q.size()-1);
                break;
            }
            else {
                q.add(sum);
                A = sum;
            }
        }
    }
}