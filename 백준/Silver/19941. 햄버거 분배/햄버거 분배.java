import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int[] people;

    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        for (int i = 0; i < people.length; i++) {
            if(people[i] != 2) continue;
            for (int j = i-K; j <= i+K; j++) {
                if(j < 0 || j >= people.length) continue;
                if(people[j] == 1) {
                    answer++;
                    people[j] = 0;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        people = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 'P') people[i] = 2;
            else people[i] = 1;
        }
    }
}