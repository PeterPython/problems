# http://www.codewars.com/kata/sum-of-pairs/train/python

def sum_pairs(ints, s):
    map = {}
    n = len(ints)
    index1 = n
    index2 = n
    checked = set()
    
    for i in range(n):
        map[ints[i]] = i
    
    m = n
    i = 0
    while i < m:
        num = ints[i]
        dif = s - num
        if dif in map and map[dif] != i and num not in checked:
            checked.add(dif)
            j = map[dif]
            if j < index2:
                index1 = i
                index2 = j
                m = j
        i += 1
    
    if index1 >= n or index2 >= n:
        return None
    
    return [ints[index1], ints[index2]]