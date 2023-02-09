

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String s = br.readLine();
			String[] arr = new String[20];
			arr = s.split(" ");
			for (String string : arr) {
				if(string.length()==1)System.out.print(string+" ");
				else {
					StringBuilder sb = new StringBuilder(string);
					System.out.print(sb.reverse().toString()+" ");
				}
			}
			System.out.println();
		}
	}
}
