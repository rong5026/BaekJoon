import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void DFS(ArrayList<Integer> list[], int visit[], int index) {

        if(visit[index] != 0)
            return ;

        visit[index] = 1;

        System.out.print(index + " ");

        for(int i : list[index]) {
            if(visit[i] == 0)
                DFS(list, visit, i);
        }
    }

    public static void BFS(ArrayList<Integer> list[] , int visit[], int index) {

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(index);

        visit[index] = 1;

        while(!queue.isEmpty()) {
            int tmp = queue.poll();
            System.out.print(tmp + " ");

            for(int i : list[tmp]) {
                if(visit[i] == 0){
                    queue.add(i);
                    visit[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int k = Integer.parseInt(str[2]);

        ArrayList<Integer> list[] = new ArrayList[n + 1];

        for(int i = 1; i <= n ; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 1 ; i <= n ; i++){
            Collections.sort(list[i]);
        }

        int visit[] = new int[n + 1];

        DFS(list, visit, k);
        System.out.println("");

        visit = new int[n + 1];

        BFS(list, visit, k);

    }
}
