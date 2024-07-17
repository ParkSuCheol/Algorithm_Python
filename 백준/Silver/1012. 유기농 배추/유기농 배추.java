import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] visit;
    static int N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int cnt = 0;

            map = new int[N][M];
            visit = new boolean[N][M];

            for (int j = 0; j < K; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int j = 0; j < N; j++){
                for (int k = 0; k < M; k++){
                    if (map[j][k] == 1 && !visit[j][k]){
                        bfs(j,k);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        int[] tmp = new int[] {x,y};
        q.add(tmp);
        visit[x][y] = true;

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while (!q.isEmpty()){
            int[] fun = q.poll();
            int fx = fun[0];
            int fy = fun[1];
            for (int k = 0; k < 4; k++){
                int nx = fx + dx[k];
                int ny = fy + dy[k];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if (map[nx][ny] == 1 && !visit[nx][ny]){
                    visit[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }
    }
}