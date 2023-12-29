import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long answer = 1;
        if(N==3) answer = 0;
        for (int i = 0; i < 4; i++) {
            answer *= N--;
        }
        answer /= 24;
        System.out.println(answer);
    }
}