# http://www.codewars.com/kata/strip-comments/train/python

import re

def solution(string,markers):
    a = string.split("\n")
    out = []
    for st in a:
        for mark in markers:
            st = re.sub(r'[\%s].*'%mark, '', st).strip()
        out.append(st)
    
    res = ""

    for i in range(0, len(out)):
        if i < len(out)-1:
            res += out[i] + "\n"
        else:
            res += out[i]
    
    return res