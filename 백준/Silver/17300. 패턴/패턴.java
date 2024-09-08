import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int L;
    static int[] arr;
    static boolean[] visit = new boolean[10];
    static Set<Integer> point = new HashSet<>(Arrays.asList(1, 3, 7, 9));
    static Set<Integer> mid = new HashSet<>(Arrays.asList(2, 4, 6, 8));

    public static void main(String[] args) throws Exception{
        input();
        visit[0] = true;
        for (int i = 1; i < L; i++) {
            int a = arr[i-1];
            int b = arr[i];
            if(a==b) break;
            if(i==1) {
                visit[a] = true;
                visit[b] = true;
                if(findMid(a, b) != 0) break;
            }
            else {
                if(visit[b]) break;
                visit[b] = true;
                if(!visit[findMid(a, b)]) break;
            }
            if(i == L-1) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    // 두 숫자 사이에 있는 수를 반환하는 함수(없으면 0)
    private static int findMid(int a, int b) {
        // 두 숫자가 꼭지점인 경우
        if (point.contains(a) && point.contains(b)) {
            return (a+b) / 2;
        }
        // 두 숫자가 중간점이고 반대편일 경우
        if (mid.contains(a) && mid.contains(b) && a + b == 10) {
            return 5;
        }
        return 0;
    }

    private static void input() throws Exception{
        L = Integer.parseInt(br.readLine());
        arr = new int[L];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < L; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}