from collections import deque
import sys

N,K = map(int,sys.stdin.readline().split())
cnt = [0 for i in range(100001)]

def bfs(s):
    que = deque([s])
    while que:
        x = que.popleft()
        if x == K:
            return cnt[K]
        for i in (x-1,x+1,x*2):
            if 0 <= i < 100001 and not cnt[i]:
                cnt[i] = cnt[x] + 1
                que.append(i)

print(bfs(N))
