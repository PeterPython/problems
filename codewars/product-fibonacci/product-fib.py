# http://www.codewars.com/kata/product-of-consecutive-fib-numbers

def productFib(prod):
    f0 = 0
    f1 = 1
    b = True
    
    while f0*f1 != prod:
        f3 = f0 + f1
        f0 = f1
        f1 = f3
        
        if f0*f1 > prod:
            b = False
            break
        
    return [f0, f1, b]
