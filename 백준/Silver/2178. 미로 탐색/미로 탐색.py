from collections import deque
n,m = map(int, input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

dy = [1,-1,0,0]
dx = [0,0,1,-1]

def bfs(s):
    cnt = 1
    que = deque([s])
    while que:
        y,x = que.popleft()
        for i in range(4):
            fy = y + dy[i]
            fx = x + dx[i]
            if 0 <= fy < n and 0 <= fx < m and graph[fy][fx] == 1:
                graph[fy][fx] = graph[y][x] + 1
                que.append([fy,fx])
                cnt += 1

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1:
            bfs([i,j])

print(graph[n-1][m-1])