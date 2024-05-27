import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws Exception{
        input();
        int answer = 0;
        // 왼쪽을 R 오른쪽을 B로 모을경우
        int count = 0, point1 = 0, point2 = 1;
        while (point1 < N - 1 && point2 < N) {
            if(point1 == point2) point2++;
            // R이라면 다음칸
            if(!arr[point1]) {
                point1++;
            }
            // B라면 오른쪽에서 R찾기
            else {
                while (point2 < N && arr[point2]) {
                    point2++;
                }
                if(point2 < N) {
                    count++;
                    point1++;
                    point2++;
                }
            }
        }
        answer = count;
        // 왼쪽을 B 오른쪽을 R로 모을경우
        count = 0; point1 = 0; point2 = 1;
        while (point1 < N - 1 && point2 < N) {
            if(point1 == point2) point2++;
            // B라면 다음칸
            if(arr[point1]) {
                point1++;
            }
            // R이라면 오른쪽에서 B찾기
            else {
                while (point2 < N && !arr[point2]) {
                    point2++;
                }
                if(point2 < N) {
                    count++;
                    point1++;
                    point2++;
                }
            }
        }

        answer = Math.min(answer, count);
        System.out.println(answer);
    }

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N];
        char[] temp = br.readLine().toCharArray();
        for (int i = 0; i < N; i++) {
            if(temp[i] == 'B') arr[i] = true;
        }
    }
}