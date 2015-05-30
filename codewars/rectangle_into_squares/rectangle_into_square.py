# http://www.codewars.com/kata/rectangle-into-squares/train/python

def sqInRect(lng, wdth):
    if lng == wdth:
        return None
        
    li = []
    sir(lng, wdth, li)
    return li
    
def sir(lng, wdth, li):
    if lng == 1 and wdth == 1:
        li.append(1)
        return
    elif lng == wdth:
        li.append(lng)
        return
        
    short = 0
    if lng > wdth:
        short = wdth
        lng = lng - short
    else:
        short = lng
        wdth = wdth - short
    
    li.append(short)
    sir(lng, wdth, li)