import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    static int M;
    static boolean[][] visit;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        bfs(0,0);
        System.out.println(arr[N-1][M-1]);
    }
    public static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x,y});

        while(!q.isEmpty()){
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i = 0; i < 4; i++){
                int newX = nowX + dx[i];
                int newY = nowY + dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M)
                    continue;
                if (visit[newX][newY] || arr[newX][newY] == 0)
                    continue;
                q.add(new int[] {newX, newY});
                arr[newX][newY] = arr[nowX][nowY] + 1;
                visit[newX][newY] = true;
            }
        }
    }
}