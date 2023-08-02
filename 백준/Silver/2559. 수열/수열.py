import sys
input = sys.stdin.readline

N,K = map(int,input().split())
graph = list(map(int,input().split()))

part = sum(graph[:K])
answer = part
for i in range(N-K):
    part += graph[i+K] - graph[i]
    if answer < part:
        answer = part
        
print(answer)