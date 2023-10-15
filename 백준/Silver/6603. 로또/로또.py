import sys,copy
input = sys.stdin.readline

def dfs(depth, index):
    if depth == 6:
        print(*tmp)
        return
    for i in range(index, k):
        tmp.append(s[i])
        dfs(depth+1,i+1)
        tmp.pop()

while True:
    graph = list(map(int, input().split()))
    k = graph[0]
    s = graph[1:]
    tmp = []
    dfs(0,0)
    if k == 0:
        break
    print()