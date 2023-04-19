import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<node>[] arr;
	static class node{
		int left, right;
		node(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new ArrayList[N+1];
		for (int i = 1; i < arr.length; i++) 
			arr[i] = new ArrayList<>();
		for (int i = 1; i < arr.length; i++) {
			int rot = sc.next().charAt(0)-64;
			int lef = sc.next().charAt(0)-64;
			int rig = sc.next().charAt(0)-64;
			arr[rot].add(new node(lef, rig));
		}
		in_order(1);
		sb.append('\n');
		pre_order(1);
		sb.append('\n');
		post_order(1);
		System.out.println(sb.toString());
	}
	private static void in_order(int x) {
		sb.append((char)(x+64));
		if(arr[x].get(0).left>0)
			in_order(arr[x].get(0).left);
		if(arr[x].get(0).right>0)
			in_order(arr[x].get(0).right);
	}
	
	private static void pre_order(int x) {
		if(arr[x].get(0).left>0)
			pre_order(arr[x].get(0).left);
		sb.append((char)(x+64));
		if(arr[x].get(0).right>0)
			pre_order(arr[x].get(0).right);
	}
	
	private static void post_order(int x) {
		if(arr[x].get(0).left>0)
			post_order(arr[x].get(0).left);
		if(arr[x].get(0).right>0)
			post_order(arr[x].get(0).right);
		sb.append((char)(x+64));
	}
}