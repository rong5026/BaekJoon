import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

public class Main {

    public static void union(int i, int j, int parent[]) {
        i = find(i, parent);
        j = find(j, parent);

        if (i < j)
            parent[j] = i;
        else
            parent[i] = j;
    }

    public static int find(int num, int parent[]) {
        if (num == parent[num])
            return num;
        return parent[num] = find(parent[num], parent);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int map[][] = new int[n + 1][n + 1];
        int input[] = new int[m + 1];
        int parent[] = new int[n + 1];

        for (int i = 1 ; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1 ; i <= n ; i++) {
            parent[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1 ; i <= m ; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1 ; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if (map[i][j] == 1)
                    union(i, j, parent);
            }
        }

        for (int i = 1 ; i <= m ; i++){
            if (parent[input[i]] != parent[input[1]]) {
                System.out.println("NO");
                return ;
            }
        }
        System.out.println("YES");
    }
}
