import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    public static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int cnt = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && v[i][j] == false) {
                    ans.add(bfs(i,j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }

    public static int bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        v[x][y] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || v[nx][ny])
                    continue;
                if (map[nx][ny] == 0)
                    continue;
                v[nx][ny] = true;
                cnt++;
                q.add(new Point(nx, ny));
            }
        }
        return cnt;
    }
}