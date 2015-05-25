# http://www.codewars.com/kata/josephus-survivor/train/python

def josephus_survivor(n,k):
    li = range(1, n+1)
    result = []
    i = 0
    var = 0
    while li:
        i += k-1
        while i >= len(li):
            i = i - len(li)
        var = li.pop(i)
        result.append(var)
    
    return result.pop()