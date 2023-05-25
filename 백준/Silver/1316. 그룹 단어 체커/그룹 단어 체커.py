N = int(input())
cnt = 0
for _ in range(N):
    lst = [0]*27
    word = list(input())
    chk = True
    for i in range(len(word)):
        if i != 0 and word[i-1] == word[i]:
            lst[ord(word[i])-97] += 1
            continue
        if lst[ord(word[i])-97] != 0:
            chk = False
            break
        lst[ord(word[i])-97] += 1
    if chk:
        cnt += 1

print(cnt)