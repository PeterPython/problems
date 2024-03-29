# http://www.codewars.com/kata/explosive-sum
# How many ways/combinations to sum to n using numbers from 1 to n
# Ex. exp_sum(3) -> 1+1+1, 2+1

def exp_sum(n):
    return e_sum(n, 0, 1)
    
def e_sum(n, current, index):
    if current == n:
        return 1
    if current > n:
        return 0
    
    count = 0
    for i in range(index, n+1):
        count += e_sum(n, current+i, i)
        
    return count



# Using Dynamic Programming
def exp_sum_memo(n):
    memo = [[0 for x in range(n+1)] for x in range(n+1)]
    return e_sum_memo(n, 1, memo)

# index is where the loop should start and increase it by 1 so it does not repeated
def e_sum_memo(n, index, memo):
    if n == 0:
        return 1
    if n < 0:
        return 0
    if memo[n][index] != 0:
        return memo[n][index]

    count = 0
    for i in range(index, n+1):
        count += e_sum_memo(n-i, i, memo)

    memo[n][index] = count
    return count


print exp_sum(10)
print exp_sum_memo(10)    

