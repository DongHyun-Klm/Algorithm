import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int total = B, min = 257, max = -1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                total += arr[i][j];
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }
        total /= N*M;
        if(total>max) total = max;

        int answer = Integer.MAX_VALUE;
        int height = min, max_height = -1;
        while (height<=total){
            int temp = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++) {
                    if(arr[i][j]>height) temp += 2*(arr[i][j] - height);
                    else temp += height - arr[i][j];
                }
            }
            answer = Math.min(answer, temp);
            if(answer==temp) max_height = height;
            height++;
        }
        System.out.println(answer + " " + max_height);
    }
}