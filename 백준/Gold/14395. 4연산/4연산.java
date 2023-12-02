import java.util.Scanner;

public class Main {
    static String ans = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextInt(), t = sc.nextInt();
        if(s == t) System.out.println(0);
        else {
            BT(1, "/", t);
            BT(s, "", t);
            if(ans.length() == 0) System.out.println(-1);
            else System.out.println(ans);
        }
    }

    private static void BT(long now, String answer, long t) {
        if(now > t) return;
        else if(now == t){
            if(ans.length() == 0 || ans.length() > answer.length()){
                ans = answer;
            }
            else if(ans.length() == answer.length()) {
                // 사전 순 앞서는 것 찾기
                char[] ansArray = ans.toCharArray();
                char[] answerArray = answer.toCharArray();
                for (int i = 0; i < ans.length(); i++) {
                    if(ansArray[i] > answerArray[i]){
                        ans = answer;
                    }
                    else if(ansArray[i] != answerArray[i]) break;
                }
            }
            return;
        }

        BT(now + now, answer + "+", t);
        if(now != 1) BT(now * now, answer + "*", t);
    }
}