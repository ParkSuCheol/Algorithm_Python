import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int S;
    static int[] arr;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        res = 0;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        if (S == 0)
            res--;

        System.out.println(res);

    }
    public static void dfs(int idx, int sum){
        if (idx == N){
            if (sum == S){
                res++;
            }
            return;
        }
        dfs(idx+1, sum+arr[idx]);
        dfs(idx+1, sum);
    }
}