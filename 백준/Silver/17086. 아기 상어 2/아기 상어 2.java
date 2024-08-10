import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] v;
    static int N, M;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};	//이동관련 X 변경값
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};	//이동관련 y 변경값

    static class Point{
        int x, y, dist;
        public Point(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        v = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    v = new boolean[N][M];
                    res = Math.max(res, bfs(i,j));
                }
            }
        }
        System.out.println(res);
    }

    public static int bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        v[x][y] = true;
        q.add(new Point(x,y,0));
        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i < 8; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)
                    continue;
                if(v[nx][ny])
                    continue;
                if(map[nx][ny] == 1)
                    return cur.dist+1;
                v[nx][ny] = true;
                q.add(new Point(nx,ny,cur.dist + 1));
            }
        }
        return 0;
    }
}