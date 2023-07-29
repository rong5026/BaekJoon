import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean arr2[][];
    static int n;
    static int m;

    static int[] dx = {0, 1, 0 , -1};
    static int[] dy = {1, 0, -1, 0};
    public static void DFS(int list[][], int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[] {i,j});
        arr2[i][j] = true;

        while(!queue.isEmpty()) {
            int now[] = queue.poll();
            for(int k = 0 ; k < 4 ; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                if (x >= 0 && x < n && y>=0 && y < m) {
                    if(arr2[x][y] == false && list[x][y] != 0) {
                        arr2[x][y] = true;
                        list[x][y] = list[now[0]][now[1]] + 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n][m];
        arr2 = new boolean[n][m];

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = Integer.parseInt(a.substring(j, j + 1));
            }
        }

        DFS(arr, 0, 0);
//        for(int i = 0 ; i < n ; i++){
//            for(int j = 0 ; j < m ; j++)
//                System.out.print(arr[i][j] + " ");
//            System.out.println("");
//        }
        System.out.println(arr[n-1][m-1]);

    }
}
