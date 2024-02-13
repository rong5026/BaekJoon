import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;

public class Main {

    static boolean visited[];
    static int check[];

    static ArrayList<Integer> list[];

    static boolean isOver;
    private static void DFS(int num) {

        visited[num] = true;

        for (int i : list[num]) {
            if (!visited[i]) {
                check[i] = (check[num] + 1) % 2;
                DFS(i);
            }
            else if (check[i] == check[num]) {
                isOver = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int node = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            list = new ArrayList[node + 1];

            for (int j = 0 ; j <= node ; j++)
                list[j] = new ArrayList<>();

            for (int j = 0 ; j < edge ; j++) {
                st = new StringTokenizer(br.readLine());

                int start = Integer.parseInt(st.nextToken());
                int last = Integer.parseInt(st.nextToken());

                list[start].add(last);
                list[last].add(start);
            }


            visited = new boolean[node + 1];
            check = new int[node + 1];
            isOver = true;

            for (int j = 1 ; j <= node ; j++) {


                if (isOver)
                    DFS(j);
                else
                    break;
            }

            if (isOver)
                System.out.println("YES");
            else
                System.out.println("NO");

        }



    }
}
