import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L, C;
	static char[] select, alphabet;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt(); C = sc.nextInt();
		select = new char[L+1];
		alphabet = new char[C+1];
		for (int i = 1; i <= C; i++) {
			alphabet[i] = sc.next().charAt(0);
		}
		Arrays.sort(alphabet);
		dfs(1, 1);
		System.out.println(sb.toString());
	}

	private static void dfs(int d, int start) {
		if(d == L+1) {
			if(canCode()) {
				for (int i = 1; i <= L; i++) {
					sb.append(select[i]);
				}
				sb.append('\n');
			}
		}
		else {
			for (int i = start; i <= C; i++) {
				select[d] = alphabet[i];
				dfs(d+1, i+1);
			}
		}
	}

	private static boolean canCode() {
		int vowel = 0, consonant = 0;
		for (int i = 1; i <= L; i++) {
			char c = select[i];
			if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u') vowel++;
			else consonant++;
		}
		if(vowel>0 && consonant >1) return true;
		return false;
	}
}