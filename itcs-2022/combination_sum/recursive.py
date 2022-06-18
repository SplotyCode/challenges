t = int(input())
for _ in range(t):
    n, m = list(map(int, input().split(" ")))
    numbers = list(map(int, input().split(" ")))
    count = 0


    def gen(sum, start=0):
        if sum == n:
            global count
            count = count + 1
            return
        elif sum > n:
            return
        for i in range(start, m):
            number = numbers[i]
            gen(sum + number, i)


    gen(0)
    print(count)
