import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int result = 1;
            Map<String, Integer> m = new HashMap<>();
            int n = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < n; j++) {
                String category = sc.nextLine().split(" ")[1];
                if(m.containsKey(category)) m.put(category, m.get(category) + 1);
                else m.put(category, 1);
            }
            for(String s : m.keySet()){
                result *= m.get(s)+1;
            }
            System.out.println(result - 1);
        }
    }
}
