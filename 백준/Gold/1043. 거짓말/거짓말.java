import com.sun.source.tree.Tree;

import org.w3c.dom.Node;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.LinkPermission;
import java.sql.Array;
import java.util.*;

import jdk.jshell.SourceCodeAnalysis;

public class Main {

	static int parent[];
	static ArrayList<Integer> party[];
    static ArrayList<Integer> truePerson;
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}

	public static int find(int a) {
		if (parent[a] == a)
			return a;
		return parent[a] = find(parent[a]);
	}

    private static boolean checkPossibleParty(int elem) {
        for (int k = 0 ; k < truePerson.size() ; k++) {
            int a = find(truePerson.get(k));

            if (a == find(elem)){
               return false;
            }
        }
        return true;
    }

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		int trueP = input.nextInt();
		truePerson = new ArrayList<Integer>();

		for (int i = 0; i < trueP; i++) {
			truePerson.add(input.nextInt());
		}

		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

        party = new ArrayList[m];

		for (int i = 0; i < m; i++) {
			int inputCount = input.nextInt();
            party[i] = new ArrayList<Integer>();

			for (int j = 0; j < inputCount; j++) {
                party[i].add(input.nextInt());
				if (j != 0) {
					union(party[i].get(j - 1),  party[i].get(j));
				}
			}
		}

        // for (int i = 1 ; i <=n ; i++){
        //     System.out.print(parent[i] + " ");
        // }

        int count = m;

        for (int i = 0 ; i < m ; i++) {

            for (int j = 0 ; j < party[i].size() ; j++) {
                int elem = party[i].get(j);

                if (!checkPossibleParty(elem)) {
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
	}


}
