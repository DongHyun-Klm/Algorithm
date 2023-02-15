import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int tc = Integer.parseInt(st.nextToken()), sum;
            int[][] arr = new int[100][100];
            ArrayList<Integer> max = new ArrayList<>();
             
            for (int j = 0; j < arr.length; j++) {
                st = new StringTokenizer(br.readLine());
                for (int j2 = 0; j2 < arr.length; j2++) {
                    arr[j][j2] = Integer.parseInt(st.nextToken());
                }
            }
             
            for (int j = 0; j < 100; j++) {
                sum = 0;
                for (int j2 = 0; j2 < 100; j2++) {
                    sum += arr[j][j2];
                }
                max.add(sum);
            }
            for (int j = 0; j < 100; j++) {
                sum = 0;
                for (int j2 = 0; j2 < 100; j2++) {
                    sum += arr[j2][j];
                }
                max.add(sum);
            }
             
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][j];
            }
            max.add(sum);
             
            sum = 0;
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][99-j];
            }
            max.add(sum);
            System.out.print("#"+tc+" ");
            System.out.println(Collections.max(max));
        }
    }
}