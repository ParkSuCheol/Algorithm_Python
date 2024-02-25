import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Set<String> set = new HashSet<>();

        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < s.length() - i + 1; j++){
                set.add(s.substring(j,j+i));
            }
        }
        bw.write(set.size() + "");

        bw.flush();
        bw.close();;
        br.close();
    }
}