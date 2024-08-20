import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N+1][M+1];
        int[][] row = new int[N][M+1];
        int[][] col = new int[N+1][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            if (y1 == y2){
                row[Math.min(x1, x2)][y1] = 1;
            }else{
                col[x1][Math.min(y1, y2)] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (row[i-1][0] == 1) break;
            dp[i][0] = 1;
        }

        for (int i = 1; i <= M; i++){
            if (col[0][i-1] == 1) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= M; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

                if (row[i-1][j] == 1){
                    dp[i][j] -= dp[i-1][j];
                }
                if (col[i][j-1] == 1){
                    dp[i][j] -= dp[i][j-1];
                }
            }
        }

        System.out.println(dp[N][M]);


    }
}