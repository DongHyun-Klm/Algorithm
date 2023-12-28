import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }
        while(!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
            if(q.isEmpty()) break;
            else q.add(q.poll());
        }
        System.out.println(sb);
    }
}