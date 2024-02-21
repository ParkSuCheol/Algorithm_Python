import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String aStr = "";
        String bStr = "";
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            aStr = st.nextToken();
            bStr = st.nextToken();
            bw.write(Strfry(aStr, bStr) + "\n");
        }
        bw.flush();
        bw.close();;
        br.close();
    }

    static String Strfry(String aStr, String bStr){
        if(aStr.length() != bStr.length())
            return "Impossible";

        int[] alphabet = new int[26];

        for(int i = 0; i < aStr.length(); i++){
            alphabet[aStr.charAt(i) - 'a']++;
            alphabet[bStr.charAt(i) - 'a']--;
        }
        for(int i : alphabet){
            if(i != 0)
                return "Impossible";
        }

        return "Possible";
    }
}