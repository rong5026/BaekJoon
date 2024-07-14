import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.management.MemoryType;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input[] = br.readLine().split("-");
		int result = 0;

		for (int i = 0 ; i < input.length ; i++) {

			String input2[] = input[i].split("\\+");

			int sum = 0;
			for (int j = 0 ; j < input2.length ; j++) {
				sum += Integer.parseInt(input2[j]);
			}

			if (i == 0) {
				result += sum;
			}
			else {
				result -= sum;
			}
		}
		System.out.println(result);




	}
}