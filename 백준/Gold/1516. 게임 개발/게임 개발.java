import com.sun.source.tree.Tree;

import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

import jdk.jshell.SourceCodeAnalysis;

public class Main {

	static 	int timeValue[];
	static ArrayList<Integer> list[];
	static int result[];

	static int indegree[];
	// public static void bfs(int i) {
	//
	// 	visited[i] = true;
	//
	//
	// 	Queue<Integer> queue = new LinkedList<>();
	// 	queue.add(i);
	//
	// 	while (!queue.isEmpty()) {
	//
	// 		totalSum += timeValue[i];
	// 		int now = queue.poll();
	//
	// 		for (int elem : list[now]) {
	// 			if (!visited[elem])
	// 				bfs(elem);
	// 		}
	// 	}
	// }
	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();

		list = new ArrayList[n + 1];
		timeValue = new int[n + 1];
		indegree = new int[n + 1];
		result = new int[n + 1];

		for (int i = 1 ; i <= n ; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 1 ; i <= n ; i++) {

			timeValue[i] = input.nextInt();
			while (true) {
				int num = input.nextInt();

				if (num == -1)
					break;
				list[num].add(i);
				indegree[i]++;
			}
		}

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1 ; i <= n ; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
			}
		}



		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int elem : list[now]) {
				indegree[elem]--;

				result[elem] = Math.max(result[elem], result[now] + timeValue[now]);
				if (indegree[elem] == 0)
					queue.add(elem);
			}
		}

		for (int i = 1; i <= n ; i++) {
			System.out.println(result[i] + timeValue[i]);
		}


		// for (int i = 1 ; i <= n ; i++) {
		// 	System.out.print(timeValue[i] + " ");
		// }
		//
		// for (int i = 1 ; i <= n ; i++) {
		//
		// 	for (int j = 0 ; j < list[i].size() ; j++) {
		// 		System.out.print(list[i].get(j) + " ");
		// 	}
		// 	System.out.println();
		// }

	}
}
