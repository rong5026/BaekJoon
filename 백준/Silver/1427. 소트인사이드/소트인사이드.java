import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.sql.Array;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] arr= str.split("");

        Arrays.sort(arr, Collections.reverseOrder());;

        StringBuilder sb = new StringBuilder();

        for(String s : arr) {
            sb.append(s);
        }

        System.out.println(sb);




    }
}