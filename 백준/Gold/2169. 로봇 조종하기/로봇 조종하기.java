import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr, dp, temp;
    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];
        temp = new int[2][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //<--
        dp[0][0] = arr[0][0];
        for(int i = 1; i < M; i++){
            dp[0][i] = dp[0][i-1] + arr[0][i];
        }

        for(int i = 1; i < N; i++){
            // 왼쪽에서 위
            temp[0][0] = arr[i][0] + dp[i-1][0];
            for(int j = 1; j < M; j++){
                temp[0][j] = arr[i][j] + Math.max(temp[0][j-1], dp[i-1][j]);
            }

            temp[1][M-1] = arr[i][M-1] + dp[i-1][M-1];
            for (int j = M-2; j >= 0; j--){
                temp[1][j] = arr[i][j] + Math.max(temp[1][j+1], dp[i-1][j]);
            }

            for(int j = 0; j < M; j++){
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }
        System.out.println(dp[N-1][M-1]);

    }

}