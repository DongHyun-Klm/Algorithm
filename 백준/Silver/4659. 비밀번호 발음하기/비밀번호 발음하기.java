import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Set<Character> vowel = new HashSet<>();
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        while (true) {
            String s = br.readLine();
            if(s.equals("end")) break;
            char[] arr = s.toCharArray();
            boolean acceptable = true, isContain = vowel.contains(arr[0]);
            int cnt = 1;
            for (int i = 1; i < arr.length; i++) {
                if(!isContain && vowel.contains(arr[i])) isContain = true;
                if(arr[i] == arr[i-1]) {
                    if(!(arr[i] == 'e' || arr[i] == 'o')) acceptable = false;
                    cnt++;
                }
                else {
                    if(vowel.contains(arr[i]) != vowel.contains(arr[i-1])) cnt = 1;
                    else cnt++;
                }
                if(cnt == 3) acceptable = false;
                if(!acceptable) break;
            }
            if(!isContain) acceptable = false;
            if(acceptable) sb.append('<').append(s).append('>').append(" is acceptable.").append('\n');
            else sb.append('<').append(s).append('>').append(" is not acceptable.").append('\n');
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
    }
}