import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String frstString = br.readLine();
        String secndString = br.readLine();

        int[] alphabet = new int[26];
        for(int i = 0; i < frstString.length(); i++){
            alphabet[(int)frstString.charAt(i) - 'a']++;
        }
        for(int i = 0; i < secndString.length(); i++){
            alphabet[(int)secndString.charAt(i) - 'a']--;
        }
        int sum = 0;
        for(int item : alphabet)
            sum += Math.abs(item);

        bw.write(sum + "");
        bw.flush();
        bw.close();
        br.close();
    }
}