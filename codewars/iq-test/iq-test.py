# http://www.codewars.com/kata/iq-test/python

def iq_test(numbers):
    li = numbers.split(" ")
    even = 0
    odd = 0
    last_even = 0
    last_odd = 0
    
    for i in range(0, len(li)):
        num = int(li[i])
        if num % 2:
            last_even = i
            even += 1
        else:
            last_odd = i
            odd += 1
        
    if even > odd:
        return last_odd + 1
    else:
        return last_even + 1