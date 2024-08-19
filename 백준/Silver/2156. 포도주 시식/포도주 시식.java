import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static Integer[] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        D = new Integer[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        D[0] = 0;
        D[1] = arr[1];
        if (N >= 2){
            D[2] = arr[1] + arr[2];
        }
        System.out.println(dp(N));
    }
    public static int dp(int N){
        if(D[N] == null){
            D[N] = Math.max(Math.max(dp(N-2), dp(N-3) + arr[N-1]) + arr[N], dp(N-1));
        }
        return D[N];
    }
}