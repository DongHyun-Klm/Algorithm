
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < N; i++) {
            int now = sc.nextInt();
            if(now > list.get(list.size()-1)) list.add(now);
            else {
                int start = 0;
                int end = list.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if(list.get(mid) < now) start = mid + 1;
                    else end = mid;
                }
                list.set(end, now);
            }
        }
        System.out.println(list.size()-1);
    }
}
