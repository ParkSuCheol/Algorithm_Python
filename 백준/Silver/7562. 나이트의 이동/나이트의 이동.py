from collections import deque

dy = [-2,-1,1,2,2,1,-1,-2]
dx = [1,2,2,1,-1,-2,-2,-1]

def bfs(s):
    que = deque([s])
    while que:
        y,x = que.popleft()
        if y == ey and x == ex:
            return graph[y][x]
        for i in range(8):
            fy,fx = y+dy[i],x+dx[i]
            if 0 <= fy < L and 0 <= fx < L and graph[fy][fx] == 0:
                graph[fy][fx] = graph[y][x]+1
                que.append([fy,fx])


T = int(input())
for _ in range(T):
    L = int(input())
    sy,sx = map(int,input().split())
    ey,ex = map(int,input().split())
    if sy == ey and sx == ex:
        print(0)
        continue
    graph = [[0]*L for _ in range(L)]
    print(bfs([sy,sx]))