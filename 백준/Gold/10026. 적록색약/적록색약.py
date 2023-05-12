from collections import deque
import copy

dy = [1,-1,0,0]
dx = [0,0,1,-1]

N = int(input())
ograph = []
xgraph = []
for i in range(N):
    ograph.append(list(input()))
    
xgraph = copy.deepcopy(ograph)
for i in range(N):
    for j in range(N):
        if xgraph[i][j] == 'G':
            xgraph[i][j] = 'R'
        
xcnt = 0
cnt = 0             
    
def bfs(s,graph):
    que = deque([s])
    setup = graph[s[0]][s[1]]
    while que:
        y,x = que.popleft()
        for i in range(4):
            fy,fx = y+dy[i],x+dx[i]
            if 0 <= fy < N and 0 <= fx < N:
                if graph[fy][fx] == setup and graph[fy][fx] != 'x':
                    graph[fy][fx] = 'x'                    
                    que.append([fy,fx])
    
for i in range(N):
    for j in range(N):
        if ograph[i][j] != 'x':
            bfs([i,j],ograph)
            xcnt += 1

for i in range(N):
    for j in range(N):
        if xgraph[i][j] != 'x':
            bfs([i,j],xgraph)
            cnt+=1
            

print(xcnt, cnt)