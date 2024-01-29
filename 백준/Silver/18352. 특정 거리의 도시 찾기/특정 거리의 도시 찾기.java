import org.w3c.dom.Node;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class Main {


    private static void BFS(int num, int sumDistance[], ArrayList<Integer> list[], boolean visited[] ) {

        Queue<Integer> queue = new LinkedList<Integer>();

        visited[num] = true;

        queue.add(num);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i : list[now]) {
                if (!visited[i]) {
                    visited[i] = true;
                    sumDistance[i] = sumDistance[now] + 1;
                    queue.add(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list[] = new ArrayList[N + 1];
        boolean visited[] = new boolean[N + 1];
        int sumDistance[] = new int[N + 1];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0 ; i < N + 1 ; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine());

            int firstCity = Integer.parseInt(st.nextToken());
            int secondCity = Integer.parseInt(st.nextToken());
            list[firstCity].add(secondCity);
        }

        BFS(X, sumDistance, list, visited);


        for (int i = 1 ; i <= N ; i++) {
            if (sumDistance[i] == K)
                result.add(i);
        }

        if (result.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(result);
            for (int i = 0; i < result.size() ; i++)
                System.out.println(result.get(i));
        }
    }
}
