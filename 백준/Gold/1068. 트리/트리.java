import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static ArrayList<Integer> list[];
	private static int deleteNode;
	private static boolean visited[];

	private static int root;

	private static int leafNode;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for (int i = 0 ; i < n ; i++){
			list[i] = new ArrayList<>();
		}

		visited = new boolean[n];
		leafNode = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			int value = Integer.parseInt(st.nextToken());

			if (value == -1) {
				root = i;
			}
			else {
				list[i].add(value);
				list[value].add(i);
			}
		}

		st = new StringTokenizer(br.readLine());
		deleteNode = Integer.parseInt(st.nextToken());

		if (deleteNode == root) {
			System.out.println("0");
		}
		else {
			DFS(root);
			System.out.println(leafNode);
		}

	}

	private static void DFS(int node) {

		visited[node] = true;
		int chlidNode = 0;

		for (int elem : list[node]) {
			if (!visited[elem] && elem != deleteNode) {
				DFS(elem);
				chlidNode++;
			}
		}
		if (chlidNode == 0) {
			leafNode++;
		}
	}
}
