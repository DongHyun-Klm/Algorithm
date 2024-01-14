import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static char[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        input();
        int ans = N, point1 = 0, point2 = 1;
        Map<Character, Integer> m = new HashMap<>();
        m.put(arr[point1], 1);
        m.put(arr[point2], m.getOrDefault(arr[point2], 0) + 1);
        while (point2 < arr.length - 1)
        {
            point2++;
            m.put(arr[point2], m.getOrDefault(arr[point2], 0) + 1);
            while (m.size() > N) {
                m.put(arr[point1], m.get(arr[point1]) - 1);
                if(m.get(arr[point1]) == 0) m.remove(arr[point1]);
                point1++;
            }
            ans = Math.max(ans, point2 - point1 + 1);
        }
        System.out.println(ans);
    }
    
    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = br.readLine().toCharArray();
    }
}