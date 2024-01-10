import java.io.*;
import java.util.Arrays;



public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char charArray[] = br.readLine().toCharArray();

        Arrays.sort(charArray);

        for (int i =  charArray.length -1 ; i >=0 ; i--) {
            bw.write(charArray[i]);
        }
        bw.flush();
        bw.close();

    }
}