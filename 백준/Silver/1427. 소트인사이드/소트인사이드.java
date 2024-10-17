
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char array[] = br.readLine().toCharArray();
		int input[] = new int[array.length];

		for (int i = 0 ; i < input.length ; i++) {
			input[i] = array[i] - '0';
		}

		Arrays.sort(input);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = input.length - 1 ; i >= 0 ; i--) {
			bw.write(input[i] + '0');
		}

		bw.flush();
		bw.close();

	}
}



