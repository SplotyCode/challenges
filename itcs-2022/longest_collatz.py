cache = {1: 1}


def collatz_count(n):
    if n not in cache:
        if n % 2 == 0:
            cache[n] = 1 + collatz_count(n / 2)
        else:
            cache[n] = 1 + collatz_count(3 * n + 1)
    return cache[n]


for _ in range(int(input())):
    a, b = input().split(" ")
    index = -1
    max = 0
    for n in range(int(a), int(b) + 1):
        value = collatz_count(n)
        if value > max:
            max = value
            index = n
    print(str(index) + " " + str(max))

# normal collatz sequence
def collatzSeq(n):
    chainNumber = 1
    current = n
    while current != 1:
        if current % 2 == 0:
            current = current/2
            chainNumber += 1
        else:
            current = (3*current) + 1
            chainNumber += 1
    return [chainNumber, n]