import sys
import copy

input = sys.stdin.readline
N,M = map(int,input().split())
graph = [] #사무실
cctv = []  #cctv 정보, x, y


mode = [
    [],
    [[0],[1],[2],[3]],
    [[0,1],[2,3]],
    [[0,3],[0,2],[1,2],[1,3]],
    [[0,1,2],[0,2,3],[0,1,3],[1,2,3]],
    [[0,1,2,3]]
]
dx = [1,-1,0,0]
dy = [0,0,1,-1]


for i in range(N):
    data = list(map(int,input().split()))
    graph.append(data)
    for j in range(M):
        if data[j] != 0 and data[j] != 6:
            cctv.append([data[j], i, j])

def go(graph, mode, x, y):
    for i in mode:
        nx,ny = x,y
        while True:
            nx += dx[i]
            ny += dy[i]
            if 0 <= nx < N and 0 <= ny < M:
                if graph[nx][ny] == 6:
                    break
                elif graph[nx][ny] == 0:
                    graph[nx][ny] = -1 
            else:
                break

min_value = int(1e9)

def dfs(depth, graph):
    global min_value

    if depth == len(cctv):
        cnt = 0
        for i in range(N):
            for j in range(M):
                if graph[i][j] == 0:
                    cnt += 1              
        min_value = min(min_value, cnt)
        return

    tmp = copy.deepcopy(graph)
    cctv_num, x, y = cctv[depth]
    for i in mode[cctv_num]:
        go(tmp, i, x, y)
        dfs(depth+1, tmp)
        tmp = copy.deepcopy(graph)

dfs(0,graph)
print(min_value)