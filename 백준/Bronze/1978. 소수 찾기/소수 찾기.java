import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] prime;
    public static void main(String[] args) throws IOException {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int res = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if(arr[i] == 0 || arr[i] == 1)
                continue;
            if(arr[i] == 2) {
                res++;
                continue;
            }

            for (int j = 2; j <= Math.sqrt(arr[i]); j++){
                if(arr[i] % j == 0){
                    cnt++;
                }
            }

            if(cnt == 0){
                res++;
            }

        }
        System.out.println(res);
    }

}