import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		char[] crr = new char[s.length()];
		crr = s.toCharArray();
		Stack<Character> left = new Stack<>();
		Stack<Character> right = new Stack<>();
		StringTokenizer st;
		for (Character character : crr) {
			left.push(character);
		}
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			switch (c) {
			case 'L':
				if(!left.isEmpty())right.push(left.pop());
				break;
			case 'D':
				if(!right.isEmpty())left.push(right.pop());
				break;
			case 'B':
				if(!left.isEmpty())left.pop();
				break;
			case 'P':
				left.push(st.nextToken().charAt(0));
			}
		}
	while (!left.isEmpty()) {
		right.push(left.pop());
	}
	while(!right.isEmpty()) {
		bw.write(right.pop());
	}
	bw.flush();
	bw.close();
		
	}
}
