import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	private static int tree[][];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		tree = new int[26][2];

		for (int i = 0 ; i < n ; i++) {

			String input[] = br.readLine().split(" ");

			int rootIdx = input[0].charAt(0) -'A';
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);

			if (left == '.')
				tree[rootIdx][0] = -1;
			else
				tree[rootIdx][0] = left - 'A';

			if (right == '.')
				tree[rootIdx][1] = -1;
			else
				tree[rootIdx][1] = right - 'A';
		}

		preOrder(0);
		System.out.println();
		inOrder(0);
		System.out.println();
		postOrder(0);
		System.out.println();
	}
	private static void preOrder(int index) {
		if (index == -1)
			return ;
		System.out.print((char)(index + 'A'));
		preOrder(tree[index][0]);
		preOrder(tree[index][1]);
	}

	private static void inOrder(int index) {
		if (index == -1)
			return ;
		inOrder(tree[index][0]);
		System.out.print((char)(index + 'A'));
		inOrder(tree[index][1]);
	}

	private static void postOrder(int index) {
		if (index == -1)
			return ;
		postOrder(tree[index][0]);
		postOrder(tree[index][1]);
		System.out.print((char)(index + 'A'));
	}
}
