import java.util.*;

public class Main {
    static class node{
        int left, right;
        node (int l, int r){
            this.left = l;
            this.right = r;
        }
    }
    static ArrayList<node>[] arr = new ArrayList[26];;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<26; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=1; i<=N; i++){
            int now = sc.next().charAt(0)-'A';
            int left = sc.next().charAt(0)-'A';
            int right = sc.next().charAt(0)-'A';
            arr[now].add(new node(left, right));
        }

        preorder(0); sb.append('\n');
        inorder(0); sb.append('\n');
        postorder(0);
        System.out.println(sb);
    }
    //전위 순회
    static void preorder(int v){
        node now = arr[v].get(0);
        sb.append((char)(v+'A'));
        if(now.left>=0) preorder(now.left);
        if(now.right>=0) preorder(now.right);
    }

    //중위 순회
    static void inorder(int v){
        node now = arr[v].get(0);
        if(now.left>=0) inorder(now.left);
        sb.append((char)(v+'A'));
        if(now.right>=0) inorder(now.right);
    }

    //후위 순회
    static void postorder(int v){
        node now = arr[v].get(0);
        if(now.left>=0) postorder(now.left);
        if(now.right>=0) postorder(now.right);
        sb.append((char)(v+'A'));
    }
}