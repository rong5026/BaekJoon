import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class Main {


    public static void DFS(ArrayList<Integer> list[], int index, int isVisited[]) {
        if (isVisited[index] == 1)
            return ;

        isVisited[index] = 1;
        System.out.print(index + " ");

        for (int i : list[index]) {
            if (isVisited[i] == 0)
                DFS(list, i, isVisited);
        }
    }

    public static void BFS(ArrayList<Integer> list[], int index, int isVisited[]) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(index);
        isVisited[index] = 1;

        while (!queue.isEmpty()) {
            int tmp = queue.poll();

            System.out.print(tmp + " ");

            for (int i : list[tmp]) {
                if (isVisited[i] == 0) {
                    isVisited[i] = 1;
                    queue.add(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input[] = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);

        ArrayList<Integer> list[] = new ArrayList[n + 1];

        for (int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1 ; i <= m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            list[first].add(second);
            list[second].add(first);
        }

        for (int i = 1 ; i <= n ; i++) {
            Collections.sort(list[i]);
        }

        int isVisited[] = new int[n + 1];

        DFS(list, start, isVisited);
        System.out.println();

        isVisited = new int[n + 1];
        BFS(list, start, isVisited);
        System.out.println();
    }
}