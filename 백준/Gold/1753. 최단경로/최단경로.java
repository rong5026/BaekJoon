import java.io.*;
import java.util.*;

class hNode {
    int v;
    int w;

    hNode(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {

    public static int array[];
    public static ArrayList<hNode> list[];
    public static boolean visited[];

    private static void init(int v, int k) {
        for (int i = 1 ; i <= v ; i++) {
            if (i == k)
                array[i] = 0;
            else
                array[i] = 99999999;
            list[i] = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        list = new ArrayList[v + 1];
        array = new int[v + 1];
        visited = new boolean[v + 1];

        init(v, k);

        for (int i = 0 ; i < e ; i++) {
            st = new StringTokenizer(br.readLine());

            int uValue = Integer.parseInt(st.nextToken());
            int vValue = Integer.parseInt(st.nextToken());
            int wValue = Integer.parseInt(st.nextToken());

            list[uValue].add(new hNode(vValue, wValue));
        }

        PriorityQueue<hNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.w));
        pq.add(new hNode(k, 0));

        while (!pq.isEmpty()) {
            hNode now = pq.poll();
            int nowV = now.v;
            int nowW = now.w;

            if (visited[nowV])
                continue;
            visited[nowV] = true;

            for (hNode next : list[nowV]) {
                int nextV = next.v;
                int nextW = next.w;

                if (array[nextV] > nowW + nextW) {
                    array[nextV] = nowW + nextW;
                    pq.add(new hNode(nextV, array[nextV]));
                }
            }
        }

        for (int i = 1; i <= v ; i++) {
            if (array[i] == 99999999)
                bw.write("INF\n");
            else
                bw.write(array[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}