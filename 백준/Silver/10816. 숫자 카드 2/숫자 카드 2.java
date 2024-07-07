import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] plusArr = new int[10000001];
        int[] minusArr = new int[10000001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > 0){
                plusArr[tmp]++;
            }else{
                tmp *= -1;
                minusArr[tmp]++;
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if (tmp > 0){
                sb.append(plusArr[tmp] + " ");
            }else{
                tmp *= -1;
                sb.append(minusArr[tmp] + " ");
            }
        }
        System.out.println(sb.toString());
    }
}