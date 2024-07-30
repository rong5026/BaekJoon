import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class hNode implements Comparable<hNode> {
    int node;
    int value;

    public hNode(int node, int value) {
        this.node = node;
        this.value = value;
    }

    @Override
    public int compareTo(hNode o) {
        return this.value - o.value;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        List<hNode>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new hNode(b, c));
        }

        PriorityQueue<Integer>[] result = new PriorityQueue[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        PriorityQueue<hNode> queue = new PriorityQueue<>();
        queue.add(new hNode(1, 0));
        result[1].add(0);

        while (!queue.isEmpty()) {
            hNode now = queue.poll();

            for (hNode next : graph[now.node]) {
                int newDist = now.value + next.value;

                if (result[next.node].size() < k) {
                    result[next.node].add(newDist);
                    queue.add(new hNode(next.node, newDist));
                } else if (result[next.node].peek() > newDist) {
                    result[next.node].poll();
                    result[next.node].add(newDist);
                    queue.add(new hNode(next.node, newDist));
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= n; i++) {
            if (result[i].size() == k) {
                bw.write(result[i].peek() + "\n");
            } else {
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }
}