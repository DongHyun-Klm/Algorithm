import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        input();
        long answer = 0;
        int half = arr.length/2;
        int[] numbers1 = new int[half];
        for(int i=0; i<half; i++) numbers1[i] = arr[i];
        if(arr.length%2==1) half++;
        int[] numbers2 = new int[half];
        for(int i=0; i<half; i++) numbers2[i] = arr[arr.length/2 + i];

        ArrayList<Integer> al = new ArrayList<>(), ar = new ArrayList<>();
        rec(0, 0, numbers1, al);
        rec(0, 0, numbers2, ar);
        // 정렬
        Collections.sort(al);
        Collections.sort(ar);

        int point1 = 0, point2 = ar.size()-1;
        while (point1 < al.size() && point2 >= 0) {
            long sum = al.get(point1) + ar.get(point2);
            if(sum == S) {
                long nl = 1, nr = 1;
                point1++;
                while(point1 < al.size()) {
                    if(Objects.equals(al.get(point1), al.get(point1 - 1))) {
                        nl++;
                        point1++;
                    }
                    else break;
                }
                point2--;
                while(point2 >= 0) {
                    if(Objects.equals(ar.get(point2), ar.get(point2 + 1))) {
                        nr++;
                        point2--;
                    }
                    else break;
                }
                answer += nr * nl;
            }
            else if(sum > S) {
                point2--;
            }
            else {
                point1++;
            }
        }

        if(S==0) answer--;
        System.out.println(answer);
    }

    private static void rec(int i, int sum, int[] numbers1, ArrayList<Integer> a) {
        if(i == numbers1.length) {
            a.add(sum);
            return;
        }
        rec(i + 1, sum, numbers1, a);
        rec(i + 1, sum + numbers1[i], numbers1, a);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}