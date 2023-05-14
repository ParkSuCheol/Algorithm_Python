from collections import deque
from pprint import pprint
M,N,K = map(int,input().split())
# M 세로, N 가로, K개의 직사각형
graph = [[0]*N for _ in range(M)]
for _ in range(K):
    sx,sy,ex,ey = map(int,input().split())
    for i in range(sy,ey):
        for j in range(sx,ex,1):
            graph[i][j] = 1

dy = [1,-1,0,0]
dx = [0,0,1,-1]
def bfs(s):
    que = deque([s])
    cnt = 1
    graph[s[0]][s[1]] = 1
    while que:
        y,x = que.popleft()
        for i in range(4):
            fy,fx = y+dy[i],x+dx[i]
            if 0 <= fy < M and 0 <= fx < N and graph[fy][fx] == 0:
                graph[fy][fx] = 1
                que.append([fy,fx])
                cnt += 1
    return cnt
res = []
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            res.append(bfs([i,j]))
print(len(res))
print(*sorted(res))