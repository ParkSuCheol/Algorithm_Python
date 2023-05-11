from collections import deque
dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(s):
    que = deque([s])
    while que:
        y,x = que.popleft()
        for i in range(4):
            fx,fy = x+dx[i],y+dy[i]
            if 0 <= fx < M and 0 <= fy < N and visited[fy][fx] == 0 and graph[fy][fx] == 1:
                que.append([fy,fx])
                visited[fy][fx] = 1


T = int(input())
for _ in range(T):
    cnt = 0
    M,N,K = map(int,input().split()) # M = 가로 , N = 세로
    graph = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]
    for _ in range(K):
        x,y = map(int,input().split())
        graph[y][x] = 1
    for i in range(N):
        for j in range(M):
            if graph[i][j] == 1 and visited[i][j] == 0: 
                bfs([i,j])
                cnt += 1
    print(cnt)