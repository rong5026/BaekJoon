import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int e, value;

    public Node(int e, int value) {
        this.e = e;
        this.value =value;
    }
}
public class Main {

    static  ArrayList<Node>[] list;
    static boolean[] visited;

    static int max = 0;
    static int node;
    public static void dfs(int x, int len){
        if(len > max) {
            max = len;
            node = x;
        }
        visited[x] = true;

        for(int i = 0 ; i < list[x].size() ; i++) {
            Node n = list[x].get(i);

            if(!visited[n.e]) {
                dfs(n.e, n.value + len);
                visited[n.e] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = input.nextInt();

        list = new ArrayList[n + 1];

        for(int i = 1 ; i <= n ; i++) {
            list[i] = new ArrayList<Node>();
        }

        for(int i = 0 ; i < n ; i++) {

            int m = input.nextInt();
            while (true) {
                int a = input.nextInt();
                if(a == -1)
                    break;
                int b = input.nextInt();
                list[m].add(new Node(a,b));
            }
        }
        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        dfs(node, 0);

        System.out.println(max);
    }
}
