# http://www.codewars.com/kata/double-cola/python

def whoIsNext(names, r):
    l = names[:]   # Make copy of list because we need to manipulate it
    name = ""
    for i in range(0, r):
        name = l.pop(0)
        for j in range(0, 2):
            l.append(name)
    
    return name


# Using Math and no extra space (Still working on it)
# def whoIsNext(names, r):
#     index = r

#     while index > len(names):
#         index = index/2 + index%2

#     return names[index-1]


for i in range(1, 100):
    names = ["Sheldon", "Leonard", "Penny", "Rajesh", "Howard"]
    print i, whoIsNext(names, i)

