import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void DFS(int index, ArrayList<Integer>[] list, int []visit) {

        if(visit[index] != 0)
            return ;

        visit[index] = 1;

        for(int i : list[index]) {
            if(visit[i] == 0)
                DFS(i, list, visit);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String []str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        ArrayList<Integer>[] list = new ArrayList[n + 1];

        for(int i = 1 ; i <= n ; i++)
            list[i] = new ArrayList<Integer>();

        for(int i = 0; i <m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int []visit = new int[n + 1];
        int count = 0;
        for(int i = 1 ; i <= n ; i++) {

            if(visit[i] == 0) {
                count++;
                DFS(i, list, visit);
            }
        }
        System.out.println(count);
    }
}