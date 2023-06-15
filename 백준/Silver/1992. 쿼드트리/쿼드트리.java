import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0;i<N;i++){
            char[] temp = sc.next().toCharArray();
            for(int j=0;j<N;j++){
                arr[i][j] = temp[j] - '0';
            }
        }
        Quad(N, 0,  0);
        System.out.print(sb);
    }
    static void Quad(int N, int r, int c){
        int start = arr[r][c];
        for(int i=r;i<r+N;i++){
            for(int j=c;j<c+N;j++){
                if(arr[i][j]!=start) {
                    sb.append('(');
                    Quad(N/2, r, c);
                    Quad(N/2, r, c+N/2);
                    Quad(N/2, r+N/2, c);
                    Quad(N/2, r+N/2, c+N/2);
                    sb.append(')');
                    return;
                }
            }
        }
        sb.append(start);
    }
}