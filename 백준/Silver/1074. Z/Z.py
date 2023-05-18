N,R,C = map(int,input().split())
def sol(N,R,C):
    if N == 0:
        return 0
    return 2*(R%2)+(C%2) + 4*sol(N-1, int(R/2), int(C/2))
print(sol(N,R,C))