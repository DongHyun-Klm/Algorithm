import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int i=0; i<T; i++){
            int N = sc.nextInt();
            int chk = (1<<10) - 1 ;
            int cnt = 0, bit=0;
            while(true){
                char[] temp = Integer.toString(N * (cnt+1)).toCharArray();
                for(char c : temp){
                    bit = bit | (1<<(c-'0'));
                }
                cnt++;
                if(bit == chk) break;
            }
            sb.append('#').append(i+1).append(' ').append(cnt*N).append('\n');
        }
        System.out.println(sb);
    }
}