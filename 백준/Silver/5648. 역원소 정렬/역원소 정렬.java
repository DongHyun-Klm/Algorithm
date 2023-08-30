import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            sb.reverse();
            arr[i] = Long.parseLong(sb.toString());
        }
        Arrays.sort(arr);
        for(long i : arr){
            System.out.println(i);
        }
    }
}
