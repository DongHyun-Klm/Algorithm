import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for(int i=0;i<tc;i++){
            int N = sc.nextInt();
            double sum = 0, cnt = 0;
            int[] arr = new int[N];
            for(int j=0;j<N;j++){
                arr[j] = sc.nextInt();
                sum += arr[j];
            }
            sum /= N;
            for(int j=0;j<N;j++){
                if(arr[j]>sum) cnt++;
            }
            sum = (cnt / N) * 100;
            System.out.printf("%.3f%%\n",sum);
        }
    }
}
