import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {

    public static void DFS(int map[][], boolean isVisited[][], Node input) {

        int dx[] = {0, 1, 0 , -1};
        int dy[] = {1, 0, -1, 0};

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int i = 0 ; i < 4 ; i++) {
                int x = now.x + dx[i];
                int y = now.y + dy[i];

                if ((x >= 0 && x < input.x) && (y >= 0 && y < input.y)) {
                    if (isVisited[x][y] == false && map[x][y] == 1) {
                        isVisited[x][y] = true;
                        map[x][y] = map[now.x][now.y] + 1;
                        queue.add(new Node(x, y));
                    }
                }
            }

        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       String input[] = br.readLine().split(" ");

       int n = Integer.parseInt(input[0]);
       int m = Integer.parseInt(input[1]);

       int map[][] = new int[n][m];

       for (int i = 0 ; i < n ; i++) {
           StringTokenizer st = new StringTokenizer(br.readLine());
           String s = st.nextToken();

           for (int j = 0 ; j < m ; j++) {
               map[i][j] = s.charAt(j) - '0';
           }
       }

       boolean visited[][] = new boolean[n][m];

       Node inputValue = new Node(n, m);

       DFS(map,  visited, inputValue);

//       for (int i = 0 ; i < n ; i++) {
//           for (int j = 0 ; j < m ; j++)
//               System.out.print(map[i][j]);
//           System.out.println();
//       }

       System.out.println(map[n - 1][m - 1]);

    }
}