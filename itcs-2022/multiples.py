import math
import itertools

t = int(input())
for i in range(t):
    a, b, n = [int(part) for part in input().split()]
    s = sorted([int(part) for part in input().split()])
    a -= 1
    #s = preprocess(s)
    ans = 0
    for num in range(1, len(s) + 1):
        for list in itertools.combinations(s, num):
            v = math.lcm(*list)
            value = (b // v) - a // v
            if len(list) % 2 != 1:
                value *= -1
            ans += value
    print(ans)