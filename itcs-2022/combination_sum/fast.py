for _ in range(int(input())):
    n, m = [int(part) for part in input().split()]
    numbers = [int(part) for part in input().split()]


    def numberOfSums(sum):
        sumCount = [0] * (sum + 1)
        sumCount[0] = 1
        for v in numbers:
            for i in range(sum - v + 1):
                # print(str(i) + " " + str(v))
                sumCount[i + v] += sumCount[i]
        return sumCount[sum]


    print(numberOfSums(n))
