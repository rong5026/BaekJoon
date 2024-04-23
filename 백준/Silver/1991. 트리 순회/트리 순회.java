import com.sun.source.tree.Tree;

import java.io.*;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

class hNode {
	int value;
	hNode left;
	hNode right;

	public hNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

public class Main {

	private static hNode[] tree;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		tree = new hNode[n + 1];

		for (int i = 0 ; i < n ; i++) {

			String input[] = br.readLine().split(" ");

			char root = input[0].charAt(0);
			char left = input[1].charAt(0);
			char right = input[2].charAt(0);

			if (root == 'A') {
				tree[root - 'A'] = new hNode(root - 'A');
			}

			if (left != '.') {
				tree[left - 'A'] = new hNode(left - 'A');
				tree[root - 'A'].left = tree[left - 'A'];
			}

			if (right != '.') {
				tree[right - 'A'] = new hNode(right - 'A');
				tree[root - 'A'].right = tree[right - 'A'];
			}
		}

		preOrder(tree[0]);
		System.out.println();
		inOrder(tree[0]);
		System.out.println();
		postOrder(tree[0]);
		System.out.println();
	}

	private static void preOrder(hNode node) {
		if (node == null)
			return ;
		System.out.print((char)(node.value + 'A'));
		preOrder(node.left);
		preOrder(node.right);
	}

	private static void inOrder(hNode node) {
		if (node == null)
			return ;
		inOrder(node.left);
		System.out.print((char)(node.value + 'A'));
		inOrder(node.right);
	}

	private static void postOrder(hNode node) {
		if (node == null)
			return ;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print((char)(node.value + 'A'));
	}

}
