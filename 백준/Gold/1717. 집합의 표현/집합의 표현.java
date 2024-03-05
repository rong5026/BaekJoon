import com.sun.source.tree.Tree;
import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

public class Main {

    static int array[];
    static int subArray[];
    static  StringBuilder sb;
    private static int findRepresentationIdx(int index) {

        if (subArray[index] == index)
            return subArray[index];

        return subArray[index] = findRepresentationIdx(subArray[index]);
        // return findRepresentationIdx(subArray[index]);
    }

    private static void find(int nodeA, int nodeB) {
        if (findRepresentationIdx(nodeA) == findRepresentationIdx(nodeB))
            sb.append("YES").append('\n');
        else
            sb.append("NO").append('\n');
    }

    private static void union(int nodeA, int nodeB) {

        int RepresentationNodeA = findRepresentationIdx(nodeA);
        int RepresentationNodeB = findRepresentationIdx(nodeB);

        if (RepresentationNodeA < RepresentationNodeB)
            subArray[RepresentationNodeB] = RepresentationNodeA;
        else
            subArray[RepresentationNodeA] = RepresentationNodeB;
    }

    private static void setArray(int type, int nodeA, int nodeB) {

        if (type == 0) {
            union(nodeA, nodeB);
        }
        else {
            find(nodeA, nodeB);
        }
    }

    private static void init(int n) {
        for (int i = 0 ; i <= n ; i++) {
            array[i] = i;
            subArray[i] = i;
        }
    }

    private static void printArray(int n) {
        for (int i = 0 ; i <= n ; i++) {
            System.out.print(subArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        String input[] = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        array = new int[n + 1];
        subArray = new int[n + 1];

        init(n);

        for (int i = 0 ; i < m ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            setArray(type, a, b);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
