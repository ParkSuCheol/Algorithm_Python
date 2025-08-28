
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N, level = 2, res, cnt;
	static int[][] map;
	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };
	static boolean[][] v;
	static int a = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int dke = 10000;
		while (check(level)) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 9) {
						bfs(i, j, level);
					}
				}
			}
			dke--;
			if(dke == 0)
				break;
		}
		System.out.println(res);
	}

	private static boolean check(int level2) {
		cnt = 0;
		int fy = 0 , fx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < level2 && map[i][j] != 0) {
					cnt++;
				}
				if(map[i][j] == 9) {
					fy = i;
					fx = j;
				}
			}
		}
		int c = 0;
		for (int d = 0; d < 4; d++) {
			int ffy = fy + dy[d];
			int ffx = fx + dx[d];
			if (ffy < 0 || ffy >= N || ffx < 0 || ffx >= N)
				continue;
			if (map[ffy][ffx] <= level2) {
				c++;
			}
		}
		
		if (cnt == 0 || c == 0)
			return false;
		else
			return true;
	}

	static void bfs(int y, int x, int lv) {
		v = new boolean[N][N];
		v[y][x] = true;
		PriorityQueue<Point> q = new PriorityQueue<Point>();
		int dist = 0;
		q.offer(new Point(y, x, dist));
		Point cur = null;
		while (!q.isEmpty()) {
		int size = q.size();
			for (int s = 0; s < size; s++) {
				cur = q.poll();
				if (map[cur.y][cur.x] < lv && map[cur.y][cur.x] != 0) {
					res += dist;
					map[cur.y][cur.x] = 9;
					map[y][x] = 0;
					a++;
					if (a == level && level < 8) {
						level++;
						a = 0;
					}
//					print();
//					System.out.println("level : " + level + ",  a : " + a + " , dist : " + dist + " , res : " + res + " , y : " + cur.y + " , x : " + cur.x);
//					System.out.println("---------------------");
					return;
				}
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || ny >= N || nx < 0 || nx >= N)
						continue;
					if (v[ny][nx])
						continue;
					if (map[ny][nx] > lv)
						continue;
					q.add(new Point(ny, nx, dist));
					v[ny][nx] = true;
				}
			}
			dist++;
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, dist;

		public Point(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}

		public int compareTo(Point o) {
			int di = 0;
			if (this.dist > o.dist)
				di = 1;
			else if (this.dist < o.dist)
				di = -1;
			else  {
				if (this.y > o.y) {
					di = 1;
				} else if (this.y < o.y) {
					di = -1;
				} else if (this.x > o.x) {
					di = 1;
				}
			}
			return di;
		}
	}

	static void print() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
