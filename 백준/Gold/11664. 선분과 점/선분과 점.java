import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static double[][] point = new double[3][3];
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        double dist1 = 0, dist2 = 0;
        int cnt = 0;
        while (!((point[0][0] == point[1][0]) && (point[0][1] == point[1][1]) && (point[0][2] == point[1][2]))) {
            if(cnt > 10000) break;
            double[] mid = {(point[0][0] + point[1][0]) / 2 , (point[0][1] + point[1][1]) / 2, (point[0][2] + point[1][2]) / 2};
            dist1 = Math.round((Math.sqrt(Math.pow(point[0][0] - point[2][0], 2) + Math.pow(point[0][1] - point[2][1], 2) + Math.pow(point[0][2] - point[2][2], 2))) * 10000000000.0) / 10000000000.0;
            dist2 = Math.round((Math.sqrt(Math.pow(point[1][0] - point[2][0], 2) + Math.pow(point[1][1] - point[2][1], 2) + Math.pow(point[1][2] - point[2][2], 2))) * 10000000000.0) / 10000000000.0;
            if(dist1 > dist2) point[0] = mid.clone();
            else point[1] = mid.clone();
            cnt++;
        }
        System.out.println(dist1);
    }

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                point[i][j] = Double.parseDouble(st.nextToken());
            }
        }
    }
}