

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int result = 0;
	private static boolean visited[];
	private static void checkLeaf(ArrayList<Integer> list[], int num) {
		visited[num] = true;

		int childNode = 0;
		for (int elem : list[num]) {
			if (!visited[elem]) {
				childNode++;
				checkLeaf(list, elem);
			}
		}
		if (childNode == 0)
			result++;
	}

	private static void dropNode(ArrayList<Integer> list[], int num) {
		visited[num] = true;

		for(int elem : list[num]) {
			if (!visited[elem]) {
				dropNode(list, elem);
			}
		}
	}

	private static boolean checkInitRoot(int n) {
		for (int i = 0 ; i < n ; i++) {
			if (visited[i] == true )
				n--;
		}
		if (n == 1)
			return true;
		return false;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> list[] = new ArrayList[n];
		visited = new boolean[n];
		int root = 0;

		for (int i = 0 ; i < n ; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0 ; i < n ; i++) {
			int elem = Integer.parseInt(st.nextToken());
			if (elem != -1) {
				list[elem].add(i);
			}
			else {
				root = i;
			}
		}


		int m = Integer.parseInt(br.readLine());

		dropNode(list, m);
		
		if (m == root) {
			result = 0;
		}
		else if (checkInitRoot(n)) {
			result = 1;
		}
		else {
			checkLeaf(list, root);
		}

		System.out.println(result);

	}
}
