import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            visit = new boolean[N+1];
            for (int j = 0; j < N; j++) {
                arr[j+1] = Integer.parseInt(st.nextToken());
            }

            int res = 0;
            for (int j = 1; j <= N; j++) {
                if(!visit[j]){
                    dfs(j);
                    res++;
                }
            }
            System.out.println(res);
        }
    }
    public static void dfs(int node){
        visit[node] = true;
        if (!visit[arr[node]]) {
            dfs(arr[node]);
        }

    }
}