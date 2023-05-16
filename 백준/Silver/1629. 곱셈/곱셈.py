A,B,C = map(int, input().split())
answer = A
def dfs(a,b,c):
    if b == 1:
        return a % c
    elif b % 2 == 0:
        return (dfs(a,b//2,c)**2)%c
    else:
        return ((dfs(a,b//2,c)**2)*a)%c
print(dfs(A,B,C))