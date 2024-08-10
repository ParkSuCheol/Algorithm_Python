import java.io.*;
import java.util.*;

public class Main {
	static int N, M, result;
	
	static int[][] map;
	static boolean[][] visited;
	
	// 상하좌우 대각
	static int[] dx = {-1, -1, 0, 1, 1,  1,  0, -1};
	static int[] dy = { 0,  1, 1, 1, 0, -1, -1, -1};
	
	// 좌표를 담을 클래스
	public static class Node {
		int x, y, dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	// 탐색
	public static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			for(int i = 0; i < 8; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) {
					continue;
				}
				
				if(visited[nextX][nextY] == true) {
					continue;
				}
				
				if(map[nextX][nextY] == 1) {
					return now.dist + 1;
				}
				
				visited[nextX][nextY] = true;
				q.offer(new Node(nextX, nextY, now.dist + 1));
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		// 맵 입력
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					visited = new boolean[N][M];
					result = Math.max(result, bfs(i, j));
				}
			}
		}
		
		System.out.println(result);
	}
}