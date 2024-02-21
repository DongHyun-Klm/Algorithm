import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, max = -1, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        input();
        odd(N, 0);
        System.out.println(min + " " + max);
    }

    private static void odd(int n, int count) {
        char[] arr = Integer.toString(n).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] - '0') % 2 == 1) count++;
        }
        if(arr.length == 1) {
            max = Math.max(max, count);
            min = Math.min(min, count);
            return;
        }

        if(arr.length == 2) {
            int sum = arr[0] + arr[1] - 2 * '0';
            odd(sum, count);
            return;
        }

        for (int i = 1; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                String s = "";
                ArrayList<Integer> al = new ArrayList<>();
                for (int k = 0; k < arr.length; k++) {
                    if(k == i || k == j) {
                        al.add(Integer.parseInt(s));
                        s = "";
                    }
                    s += arr[k];
                }
                al.add(Integer.parseInt(s));
                int sum = 0;
                for(int t : al) sum += t;
                odd(sum, count);
            }
        }


    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}