import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] v;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;

    public static int solution(String[] maps) {
        int answer = 0;
        M = maps.length; // 행의 개수
        N = maps[0].length(); // 열의 개수
        map = new char[M][N]; // 배열 크기 설정
        v = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String tmp = maps[i];
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        int result = 0;

        // 'S'에서 'L'까지의 거리
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'S') {
                    int distanceL = bfs(i, j, 'L');
                    if (distanceL == -1) {
                        return -1;
                    }
                    result += distanceL;
                }
            }
        }

        // 방문 배열 초기화
        v = new boolean[M][N];

        // 'L'에서 'E'까지의 거리
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'L') {
                    int distanceE = bfs(i, j, 'E');
                    if (distanceE == -1) {
                        return -1;
                    }
                    result += distanceE;
                }
            }
        }

        return result;
    }

    public static int bfs(int x, int y, char target) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        v[x][y] = true;
        int cnt = 0;

        // BFS 시작
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] tmp = q.poll();
                int fx = tmp[0];
                int fy = tmp[1];

                // 4방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = fx + dx[d];
                    int ny = fy + dy[d];

                    // 경계 체크
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                        continue;
                    }

                    // 목표를 찾았을 때
                    if (!v[nx][ny] && map[nx][ny] == target) {
                        return cnt + 1; // 현재 거리 반환
                    }

                    // 'O'일 때 큐에 추가
                    if (!v[nx][ny] && map[nx][ny] != 'X') {
                        v[nx][ny] = true;
                        q.add(new int[] {nx, ny});
                    }
                }
            }
            cnt++; // 한 레벨 탐색이 끝나면 거리 증가
        }
        return -1; // 목표를 찾지 못한 경우
    }
}
