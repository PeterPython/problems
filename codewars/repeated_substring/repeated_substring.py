# http://www.codewars.com/kata/repeated-substring/train/python

def f(s):
    first = True
    completed = False
    prev = ""
    current = ""
    minimum = len(s)
    for i in range(1, len(s)/2 + 1):
        first = True
        completed = True
        for j in range(0, len(s), i):
            p = s[j:j+i]
            if first:
                prev = p
            else:
                if p != prev:
                    completed = False
                    break
                
            first = False
        if completed:
            if len(prev) < minimum:
                minimum = len(prev)
            
    if len(s) / minimum <= 1:
        return (s, 1)
    else:
        return (s[0: minimum], len(s) / minimum)