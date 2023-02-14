import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Character> left = new Stack<>();
		Queue<Character> right = new LinkedList<>();
		boolean flag = false;
		
		String s = br.readLine();
		char[] arr = new char[s.length()];
		arr = s.toCharArray();
		for (char c : arr) {
			if (c == '<') {
				flag = true;
				while (!left.isEmpty()) {
					bw.write(left.pop());
				}
				bw.flush();
			}
			if (flag == false) {
				if(c==' ') {
					while (!left.isEmpty()) {
						bw.write(left.pop());
					}
					bw.write(' ');
					bw.flush();
				}
				else left.push(c);
			}
			if (flag == true) {
				right.add(c);
				if (c == '>') {
					flag = false;
					while (!right.isEmpty()) {
						bw.write(right.poll());
					}
					bw.flush();
				}
			}

		}
		while (!left.isEmpty()) {
			bw.write(left.pop());
		}
		bw.flush();

	}
}
