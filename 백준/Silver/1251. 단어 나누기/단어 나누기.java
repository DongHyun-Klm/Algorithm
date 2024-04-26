import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String s;

    public static void main(String[] args) throws IOException {
        input();
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int i = 1; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                String voc = re(i,j);
                pq.add(voc);
            }
        }
        System.out.print(pq.peek());
    }

    private static String re(int n1, int n2) {
        char[] arr = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        for (int i = 0; i < n1; i++) {
            s1.append(arr[i]);
        }
        for (int i = n1; i < n2; i++) {
            s2.append(arr[i]);
        }
        for (int i = n2; i < arr.length; i++) {
            s3.append(arr[i]);
        }

        return s1.reverse().toString() + s2.reverse().toString() + s3.reverse().toString();
    }

    private static void input() throws IOException {
        s = br.readLine();
    }
}