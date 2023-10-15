import sys, heapq

st = []
n = int(sys.stdin.readline())
for i in range(n):
	num = int(sys.stdin.readline())
	if num:
		heapq.heappush(st, (abs(num), num))
	else:
		if st:
			print(heapq.heappop(st)[1])
		else:
			print(0)