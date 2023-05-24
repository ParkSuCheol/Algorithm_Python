import math

N = int(input())
for _ in range(N):
    x,y = map(int,input().split())
    bridge = math.factorial(y) // (math.factorial(x)*math.factorial(y-x))
    print(bridge)