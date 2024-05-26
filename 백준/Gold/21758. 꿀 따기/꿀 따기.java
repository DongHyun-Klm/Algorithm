import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[] arr;
    static long[] leftSum, rightSum;

    public static void main(String[] args) throws Exception{
        input();
        // 일단 모든 꿀을 따는 경우 값 구하기
        long sum = leftSum[N-1] * 2;

        // 꿀통이 오른쪽 끝일때 꿀을 못따는 값의 최소를 구하기
        long min = Long.MAX_VALUE;
        for (int i = 1; i < N; i++) {
            min = Math.min(min, arr[i] * 2 + leftSum[i-1]);
        }
        long answer = sum - arr[0] - min;

        // 꿀통이 왼쪽 끝일때 꿀을 못따는 값의 최소를 구하기
        min = Long.MAX_VALUE;
        for (int i = N-2; i > 0; i--) {
            min = Math.min(min, arr[i] * 2 + rightSum[i+1]);
        }
        answer = Math.max(answer, sum - arr[N-1] - min);

        // 꿀통이 중간에 있을때는 벌이 무조건 양끝
        min = Long.MAX_VALUE;
        for (int i = 1; i < N-1; i++) {
            min = Math.min(leftSum[i - 1] + rightSum[i + 1], min);
        }
        answer = Math.max(answer, sum - min - arr[0] - arr[N-1]);

        System.out.println(answer);
    }

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        leftSum = new long[N];
        rightSum = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            leftSum[i] = arr[i];
            if(i>0) leftSum[i] += leftSum[i-1];
        }
        for (int i = N-1; i >= 0; i--) {
            rightSum[i] = arr[i];
            if(i<N-1) rightSum[i] += rightSum[i+1];
        }
    }
}