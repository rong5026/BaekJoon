
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {


	private static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b= Long.parseLong(st.nextToken());

		long result = gcd(a, b);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (result != 0) {
			bw.write("1");
			result--;
		}

		bw.flush();
		bw.close();

	}
}
