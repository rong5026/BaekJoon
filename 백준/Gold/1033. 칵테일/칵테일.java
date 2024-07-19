import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class hNode {
	int index;
	int p, q;

	public hNode(int index, int p, int q) {
		this.index = index;
		this.p = p;
		this.q = q;
	}


}

public class Main {

	static long result[];
	static boolean visited[];
	static ArrayList<hNode> input[];

	private static long GCD(long a, long b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	private static void DFS(int index) {
		visited[index] = true;

		for (hNode elem : input[index]) {
			int next = elem.index;
			if (!visited[next]) {
				result[next] = result[index] * elem.q / elem.p;
				DFS(next);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		result = new long[n];
		visited = new boolean[n];
		input = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			input[i] = new ArrayList<>();
		}

		long lcm = 1;

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			input[a].add(new hNode(b, p, q));
			input[b].add(new hNode(a, q, p));

			lcm *= (p * q / GCD(p, q));
		}

		result[0] = lcm;

		DFS(0);

		long mgcd = result[0];
		for (int i = 1; i < n; i++) {  // index 1부터 시작하여 mgcd를 계산
			mgcd = GCD(mgcd, result[i]);
		}

		for (int i = 0; i < n; i++) {
			System.out.print(result[i] / mgcd + " ");
		}
	}
}