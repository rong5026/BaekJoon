
import java.io.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static long[] tree;

	private static long getSum(int b, int c) {
		long sum = 0;

		while (b <= c) {
			if (b % 2 == 1) {
				sum += tree[b];
				b++;
			}

			if (c % 2 == 0) {
				sum += tree[c];
				c--;
			}
			b = b / 2;
			c = c /2;
		}
		return  sum;
	}
	private static void changeValue(int i, long value) {
		long diff = value - tree[i];
		while (i > 0) {
			tree[i] = tree[i] + diff;
			i = i / 2;
		}
	}
	private static void setTree(int i) {
		while (i != 1) {
			tree[i / 2] += tree[i];
			i--;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int treeHeight = 0;
		int length = n;

		while (length != 0) {
			length /= 2;
			treeHeight++;
		}
		int treeSize = (int)Math.pow(2, treeHeight + 1);
		int leftNodeStartIndex = treeSize / 2 - 1;
		tree = new long[treeSize + 1];

		for (int i = leftNodeStartIndex + 1 ; i <= leftNodeStartIndex + n ; i++) {
			tree[i] = Long.parseLong(br.readLine());
		}

		setTree(treeSize - 1);

		for (int i = 0 ; i < m + k ; i++) {
			st = new StringTokenizer(br.readLine());
			long a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				changeValue(leftNodeStartIndex + b, c);
			}
			else if (a == 2) {
			 b += leftNodeStartIndex;
			 c +=  leftNodeStartIndex;
			 System.out.println(getSum(b, (int)c));
			}
		}

	}
}



