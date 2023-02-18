import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int l = str.length();

        char[] sub = new char[l];

        for (int i = 0; i < l; i++) {

            sub[i] = str.charAt(i);

        }

        int cnt = 0;

        for (int i = 0; i < l - 1; i++) {

            if (sub[0] == sub[l - 1]) {
                if (sub[i] != sub[i + 1]) {
                    cnt++;
                }
            } else if (sub[0] != sub[l - 1]) {
                if (sub[i] != sub[i + 1]) {
                    cnt++;
                }
            }
// 101010
        }
        if (sub[0] != sub[l - 1]) cnt = cnt+1;
        System.out.println(cnt / 2);
    }

}