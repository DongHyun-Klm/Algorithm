import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), answer = 0;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int index = 0, index2 = N-1, last = 0;
        // 음수, 0부터 처리
        while (index < N) {
            if(arr[index] > 0) break;
            if(arr[index] == 0) {
                if(last < 0) last = 0;
            }
            else {
                if(last != 0) {
                    answer += last * arr[index];
                    last = 0;
                }
                else last = arr[index];
            }
            index++;
        }
        answer += last;
        last = 0;

        // 양수 처리
        while(index2 >= index) {
            if(last != 0) {
                int max = last * arr[index2] > last + arr[index2] ? last * arr[index2] : last + arr[index2];
                answer += max;
                last = 0;
            }
            else last = arr[index2];
            index2--;
        }
        answer += last;

        System.out.print(answer);
    }
}