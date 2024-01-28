import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        input();
        Set<String> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            switch (st.nextToken()) {
                case "enter" :
                    s.add(person);
                    break;
                case "leave" :
                    s.remove(person);
                    break;
            }
        }
        String[] arr = new String[s.size()];
        int index = 0;
        for(String t : s) {
            arr[index++] = t;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}