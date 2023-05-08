from collections import deque
from pprint import pprint
 
R,C = map(int, input().split())
matrix = []
fire = [[0] * C for _ in range(R)]
human = [[0] * C for _ in range(R)]

hq = deque()
fq = deque()

for i in range(R):
    matrix.append(list(input()))
    for j in range(C):
        if matrix[i][j] == 'J':
            hq.append([i,j])
            human[i][j] = 1
        elif matrix[i][j] == 'F':
            fq.append([i,j])
            fire[i][j] = 1

dr = [1,-1,0,0]
dc = [0,0,1,-1]

def fbfs():
    while fq:
        r,c = fq.popleft()
        for i in range(4):
            nr,nc = r+dr[i], c+dc[i]
            if not (0 <= nr < R and 0 <= nc < C):
                continue
            if matrix[nr][nc] == "#" or fire[nr][nc]:
                continue
            fire[nr][nc] = fire[r][c] + 1
            fq.append((nr, nc))

def hbfs():
    while hq:
        r,c = hq.popleft()
        for i in range(4):
            nr,nc = r+dr[i], c+dc[i]
            if not (0 <= nr < R and 0 <= nc < C):
                print(human[r][c])
                return
            if human[nr][nc] or matrix[nr][nc] == "#":
                continue
            if fire[nr][nc] and human[r][c] + 1 >= fire[nr][nc]:
                continue
            human[nr][nc] = human[r][c] + 1
            hq.append((nr, nc))
    print("IMPOSSIBLE")
    return

fbfs()
hbfs()