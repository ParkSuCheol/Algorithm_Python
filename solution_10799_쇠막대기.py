lazor = list(input())
answer = 0
st = []

for i in range(len(lazor)):
    if lazor[i] == "(":
        st.append("(")
    else:
        if lazor[i-1] == '(':
            st.pop()
            answer += len(st)
        else:
            st.pop()
            answer += 1

print(answer)