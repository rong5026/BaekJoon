import com.sun.source.tree.Tree;

import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

import jdk.jshell.SourceCodeAnalysis;

class hNode {
	int weight;
	int lastCity;

	hNode(int lastCity, int weight) {
		this.weight = weight;
		this.lastCity = lastCity;
	}
}

public class Main {

	static ArrayList<hNode> list[];
	static Long balance[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		list = new ArrayList[n + 1];
		balance = new Long[n + 1];
		visited = new boolean[n + 1];
		for (int i = 1; i <= n ; i++) {
			list[i] = new ArrayList<hNode>();
			balance[i] = 999999999999L;
		}

		for (int i = 0 ; i < m ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int startCity = Integer.parseInt(st.nextToken());
			int lastCity = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[startCity].add(new hNode(lastCity, weight));
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int last = Integer.parseInt(st.nextToken());
		balance[start] = 0L;

		PriorityQueue<hNode> queue = new PriorityQueue<>(Comparator.comparingLong(hNode -> hNode.weight));

		queue.add(new hNode(start, 0));

		while (!queue.isEmpty()) {

			hNode now = queue.poll();

			if (visited[now.lastCity])
				continue;

			visited[now.lastCity] = true;

			for (hNode next : list[now.lastCity]) {

				if (balance[next.lastCity] > now.weight + next.weight) {
					balance[next.lastCity] = (long)(now.weight + next.weight);
					queue.add(new hNode(next.lastCity, now.weight + next.weight));

				}
			}
		}

		System.out.println(balance[last]);
	}
}