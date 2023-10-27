import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        int[] group1 = new int[A], group2 = new int[B];
        TreeSet<Integer> s1 = new TreeSet<>();
        TreeSet<Integer> s2 = new TreeSet<>();
        int answer = 0;
        for(int i=0; i<group1.length; i++) {
            group1[i] = sc.nextInt();
            s1.add(group1[i]);
        }
        for(int i=0; i<group2.length; i++) {
            group2[i] = sc.nextInt();
            s2.add(group2[i]);
        }
        for(int i=0; i<group1.length; i++) {
            if(!s2.contains(group1[i])) answer++;
        }
        for(int i=0; i<group2.length; i++) {
            if(!s1.contains(group2[i])) answer++;
        }
        System.out.println(answer);
    }
}