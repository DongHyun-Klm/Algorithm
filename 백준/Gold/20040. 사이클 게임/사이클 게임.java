import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), number = 0;
        p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            if(findSet(x) == findSet(y)) {
                number = i+1;
                break;
            }
            else {
                union(x, y);
            }
        }
//        System.out.println(Arrays.toString(p));
        System.out.println(number);
    }
    private static void union(int x, int y) {
        int a = findSet(x);
        int b = findSet(y);
        if(a > b) {
            p[findSet(a)] = findSet(b);
        }
        else p[findSet(b)] = findSet(a);
    }
    private static int findSet(int x) {
        if(p[x] != x){
            p[x] = findSet(p[x]);
        }
        return p[x];
    }
}