from collections import deque

n,m = map(int,input().split())
graph = []
visited = [[0]*m for _ in range(n)]

for _ in range(n):
    graph.append(list(map(int,input().split())))

dx = [1,-1,0,0]
dy = [0,0,1,-1]

def bfs(s):
    que = deque([s])
    visited[s[0]][s[1]] = 1
    area = 1
    while que: 
        x,y = que.popleft()
        for i in range(4):
            fx, fy = x+dx[i], y+dy[i]
            if 0 <= fx < n and 0 <= fy < m and visited[fx][fy] == 0:
                visited[fx][fy] = 1
                if graph[fx][fy] == 1:
                    area += 1
                    que.append([fx,fy])
    return area

cntBox = 0
maxArea = 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 1 and visited[i][j] == 0:
            cntBox += 1
            chkArea = bfs([i,j])
            if maxArea < chkArea:
                maxArea = chkArea

print(cntBox)
print(maxArea)