import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;

    public static void main(String[] args) throws IOException {
        input();
        ArrayList<Integer> al = new ArrayList<>();
        int point1 = 2, point2 = 1;
        while (point2 != 50000) {
            long G = (long) (Math.pow(point1, 2) - Math.pow(point2, 2));
            if(G == N) {
                al.add(point1);
                point1++;
                point2++;
            }
            else if(G > N){
                point2++;
            }
            else {
                point1++;
            }
        }
        if(al.isEmpty()) System.out.println(-1);
        for(int t : al){
            System.out.println(t);
        }
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
    }
}