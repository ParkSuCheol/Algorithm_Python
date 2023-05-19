N = int(input())

graph = []
for i in range(N):
    graph.append(list(map(int,input().split())))
min, zero, plus = 0,0,0

def check(y,x,n):
    global min,zero,plus
    curr = graph[y][x]
    for i in range(y,y+n):
        for j in range(x,x+n):
            if graph[i][j] != curr:
                nextN = n // 3
                check(y,x,nextN) # 1
                check(y,x+nextN,nextN) # 2
                check(y,x+(2*nextN),nextN) # 3
                check(y+nextN,x,nextN) # 4
                check(y+nextN,x+nextN,nextN) # 5
                check(y+nextN,x+(2*nextN),nextN) # 6
                check(y+(2*nextN),x,nextN) # 7
                check(y+(2*nextN),x+nextN,nextN) # 8
                check(y+(2*nextN),x+(2*nextN),nextN) # 9
                return
    if curr == -1 : 
        min += 1
    elif curr == 0 : 
        zero += 1
    elif curr == 1:
        plus += 1
    return

check(0,0,N)

print(min)
print(zero)
print(plus)