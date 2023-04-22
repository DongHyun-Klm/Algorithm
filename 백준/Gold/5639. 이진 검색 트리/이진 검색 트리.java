import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static class node{
		int v;
		node left, right;
		node(int v){
			this.v = v;
		}
		void insert(node x) {
			if(this.v>x.v) {
				if(this.left == null) {
					this.left = x;
				}
				else this.left.insert(x);
			}
			else {
				if(this.right == null) {
					this.right = x;
				}
				else this.right.insert(x);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		node root = new node(Integer.parseInt(br.readLine()));
		while (true) {
			String input = br.readLine();
			if(input==null||input.equals("")) break;
			node x = new node(Integer.parseInt(input));
			root.insert(x);
		}
		post_order(root);
		System.out.println(sb.toString());
	}
	private static void post_order(node n) {
		if(n.left!=null)post_order(n.left);
		if(n.right!=null)post_order(n.right);
		sb.append(n.v).append('\n');
	}
}