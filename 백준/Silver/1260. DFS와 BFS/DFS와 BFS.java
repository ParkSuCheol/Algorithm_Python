import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, V;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
        for (int i = 1; i <= N; i++)
            Collections.sort(adj[i]);

        dfs(V);
        System.out.println(sb);

        Arrays.fill(visit, false);

        sb = new StringBuilder();

        bfs(V);
        System.out.println(sb);
    }

    public static void dfs (int x){
        visit[x] = true;
        sb.append(x).append(' ');
        for (int y : adj[x]) {
            if (!visit[y]) {
                dfs(y);
            }
        }
    }

    public static void bfs (int x){
        Queue<Integer> q = new LinkedList<>();
        visit[x] = true;
        q.add(x);
        while(!q.isEmpty()){
            x = q.poll();
            sb.append(x).append(' ');
            for (int y : adj[x]) {
                if (!visit[y]) {
                    q.add(y);
                    visit[y] = true;
                }
            }
        }
    }
}