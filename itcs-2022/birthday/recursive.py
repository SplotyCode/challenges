persons = []


class Person:
    def __init__(self):
        self.add = []
        self.remove = []


def next(index, add, remove):
    global persons
    if index == len(persons):
        return True
    person = persons[index]
    index += 1
    for a in person.add:
        if a in add:
            return next(index, add, remove)
    for a in person.remove:
        if a in remove:
            return next(index, add, remove)
    for a in person.add:
        if a not in remove:
            add.add(a)
            if next(index, add, remove):
                return True
            add.remove(a)
    for a in person.remove:
        if a not in add:
            remove.add(a)
            if next(index, add, remove):
                return True
            remove.remove(a)
    return False


n, m = [int(part) for part in input().split()]
for _ in range(n):
    person = Person()
    for rule in input().split():
        num = int(rule[1:])
        if rule[0] == "+":
            person.add.append(num)
        elif rule[0] == "-":
            person.remove.append(num)
        else:
            print("error")

    persons.append(person)
print(str(next(0, set(), set())).lower())
