
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


	private static int gcd(int a, int b) {

		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0 ; i < n ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			System.out.println(a * b / gcd(a, b));
		}


	}
}
