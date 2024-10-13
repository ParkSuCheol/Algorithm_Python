import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int sum = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int tmp = c -'0' -48;
            //System.out.println(tmp);
            sum += tmp * (int)Math.pow(31, i);
        }
        System.out.println(sum);
    }
}