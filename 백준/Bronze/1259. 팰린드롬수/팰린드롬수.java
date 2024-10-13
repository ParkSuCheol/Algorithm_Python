import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            String s = String.valueOf(N);
            StringBuilder sb = new StringBuilder(s);
            if(s.equals(sb.reverse().toString())){
                System.out.println("yes");
            }else
                System.out.println("no");
        }
    }
}