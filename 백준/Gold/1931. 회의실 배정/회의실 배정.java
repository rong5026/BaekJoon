
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class hNode {
	int start;
	int end;

	public hNode(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// PriorityQueue<hNode> queue = new PriorityQueue<>(Comparator.comparingInt((hNode o) -> o.end).thenComparingInt(o-> o.start));
		PriorityQueue<hNode> queue = new PriorityQueue<>((o1, o2) -> o1.end != o2.end ? Integer.compare(o1.end, o2.end) : Integer.compare(o1.start, o2.start) );
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			queue.add(new hNode(a, b));
		}

		int cnt = 0;
		int start = 0;
		while (!queue.isEmpty()) {
			hNode node = queue.poll();
			if (node.start >= start) {
				start = node.end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
