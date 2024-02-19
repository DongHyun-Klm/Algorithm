import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[] pre, in;
    static class node {
        int v;
        node left, right;

        public node(int v) {
            this.v = v;
        }

        @Override
        public String toString() {
            return "node{" +
                    "v=" + v +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-->0) {
            input();
            node tree = retrace(0, 0, n);
            postorder(tree);
            sb.append('\n');
        }
        System.out.print(sb);
    }

    private static void postorder(node tree) {
        if(tree.left != null) postorder(tree.left);
        if(tree.right != null) postorder(tree.right);
        sb.append(tree.v).append(' ');
    }

    private static node retrace(int idx, int start, int end) {
        if(idx >= n) return null;
//        System.out.print("idx = " + idx + " " + pre[idx]);
//        System.out.print("  start = " + start);
//        System.out.println("  end = " + end);

        int rootIdx = -1;
        for(int i=start; i<end; i++){
            if(pre[idx] == in[i]) rootIdx = i;
        }
        if(rootIdx == -1) return null;

        node node = new node(pre[idx]);
        node.left = retrace(idx+1, start, rootIdx);
        node.right = retrace(idx+1+rootIdx-start, rootIdx + 1, end);
        return node;
    }
    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        pre = new int[n];
        in = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) pre[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) in[i] = Integer.parseInt(st.nextToken());
    }
}