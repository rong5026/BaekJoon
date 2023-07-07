import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0 ; i < n ; i++) {
            int m = Integer.parseInt(br.readLine());
            list.add(m);
        }
        Collections.sort(list);

        for(int i = 0 ; i < n ; i++) {
           sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);

    }
}