
import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int elem = Integer.parseInt(br.readLine());
			queue.add(elem);
		}

		int sum = 0;
		while (queue.size() != 1) {
			int a = queue.poll();
			int b = queue.poll();
			sum += a + b;
			queue.add(a + b);
		}
		System.out.println(sum);

	}
}
