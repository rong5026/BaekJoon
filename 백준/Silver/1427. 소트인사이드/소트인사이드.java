
import java.io.*;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char input[] = br.readLine().toCharArray();
		int array[] = new int[input.length];

		for (int i = 0 ; i < input.length ; i++){
			array[i] = input[i] - '0';
		}

		// 버블 정렬
		// for (int i = 0 ; i < input.length - 1 ; i++) {
		// 	for (int j = 0 ; j < input.length - i -1 ; j++) {
		//
		// 		if (array[j] < array[j + 1]){
		// 			int tmp = array[j];
		// 			array[j] = array[j + 1];
		// 			array[j + 1] = tmp;
		// 		}
		// 	}
		// }

		// 선택정렬
		// for (int i = 0 ; i < input.length - 1 ; i++) {
		// 	int maxIdx = i;
		// 	for (int j = i ; j < input.length ; j++) {
		// 		if (array[j] > array[maxIdx]) {
		// 			maxIdx = j;
		// 		}
		// 	}
		// 	int tmp = array[i];
		// 	array[i] = array[maxIdx];
		// 	array[maxIdx] = tmp;
		// }

		// 삽입정렬
		for (int i = 1 ; i < input.length ; i++) {
			for (int j = i ; j > 0 ; j--) {
				if (array[j - 1] < array[j]) {
					int tmp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = tmp;
				}
			}
		}

		for (int i = 0 ; i < input.length ; i++) {
			bw.write(array[i] + '0');
		}

		bw.flush();
		bw.close();




	}
}
