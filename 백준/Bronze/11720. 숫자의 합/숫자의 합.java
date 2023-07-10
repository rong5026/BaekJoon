import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    String str = br.readLine();

    char [] array = str.toCharArray();
    int sum = 0;

    for(char c : array) {
        sum += c - '0';
    }
    System.out.println(sum);

    }
}