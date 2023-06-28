
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int N, K;
    static class node{
        int x, dist;
        node(int x, int dist){
            this.x = x;
            this.dist = dist;
        }
        public String toString(){
            return x + " " + dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        BFS();
    }
    private static void BFS() {
        Deque<node> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        queue.add(new node(N, 0));
        visited[N] = true;
        while (!queue.isEmpty()) {
            node now = queue.poll();
            if(now.x == K) {
                System.out.println(now.dist);
                return;
            }
            // * 2
            int x = now.x;
            while (2 * x <= 100000 && x != 0) {
                x *= 2;
                if(x == K || !visited[x]) {
                    visited[x] = true;
                    queue.addFirst(new node(x, now.dist));
                }
            }
            // + 1
            if(now.x < 100000 && !visited[now.x+1]) {
                visited[now.x+1] = true;
                queue.add(new node(now.x+1, now.dist+1));
            }
            // - 1
            if(now.x > 0 && !visited[now.x-1]) {
                visited[now.x-1] = true;
                queue.add(new node(now.x-1, now.dist+1));
            }
        }
    }
}