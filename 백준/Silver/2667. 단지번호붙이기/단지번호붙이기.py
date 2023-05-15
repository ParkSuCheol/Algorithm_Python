from collections import deque
N = int(input())
graph = []
for i in range(N):
    graph.append(list(map(int,input())))
dy = [1,-1,0,0]
dx = [0,0,1,-1]
def bfs(s):
    que = deque([s])
    count = 1
    graph[s[0]][s[1]] = 0
    while que:
        y,x = que.popleft()
        for i in range(4):
            fy,fx = y+dy[i],x+dx[i]
            if 0<=fy<N and 0<=fx<N and graph[fy][fx] == 1:
                graph[fy][fx] = 0
                que.append([fy,fx])
                count += 1
    return count

answer = []
for i in range(N):
    for j in range(N):
        if graph[i][j] == 1:
            answer.append(bfs([i,j]))

print(len(answer))
answer = sorted(answer)
for i in range(len(answer)):
    print(answer[i])