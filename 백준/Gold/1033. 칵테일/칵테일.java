
import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

class hNode {
	int node, p, q;

	public hNode(int node, int p, int q) {
		this.node = node;
		this.p = p;
		this.q = q;
	}
}

public class Main {

	private static int n;
	private static ArrayList<hNode>[] nodes;
	private static boolean[] visited;
	private static long[] result;

	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	private static void dfs(int node) {
		visited[node] = true;

		for (hNode elem : nodes[node]) {
			int nextNode = elem.node;
			if (!visited[nextNode]) {
				result[nextNode] = result[node] * elem.q / elem.p;
				dfs(nextNode);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		nodes  = new ArrayList[n];
		visited = new boolean[n];
		result = new long[n];

		long lcm = 1;

		for (int i = 0 ; i < n ; i++ ){
			nodes[i] = new ArrayList<hNode>();
		}

		for (int i = 0 ; i < n - 1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			nodes[a].add(new hNode(b, p ,q));
			nodes[b].add(new hNode(a, q, p));

			// 공배수 구하기
			lcm *= (p * q / gcd(p, q));
		}

		result[0] = lcm;
		dfs(0);

	
		long mlcm = result[0];

		for (int i = 1 ; i < n ; i++) {
			mlcm = gcd(mlcm, result[i]);
		}

		for (int i = 0 ; i < n ; i++) {
			System.out.print(result[i] / mlcm + " ");
		}

	}
}
