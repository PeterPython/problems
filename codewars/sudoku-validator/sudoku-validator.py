# http://www.codewars.com/kata/sudoku-solution-validator/python

import math 
def validSolution(board):
    n = 9
    m = math.sqrt(n)

    rows = [0] * n
    columns = [0] * n
    box = [[0 for x in range(m)] for x in range(m)] 

    for i in range(0,n):
        for j in range(0,n):
            r = i/n
            c = j/n
            value = board[i][j]

            if value == 0:
                continue
                
            if (rows[i] >> value) & 1 == 1:
                return False
            else:
                mask = 1 << value
                rows[i] = rows[i] | mask
            
            if (columns[j] >> value) & 1 == 1:
                return False
            else:
                mask = 1 << value
                columns[j] = columns[j] | mask
            
            if (box[r][c] >> value) & 1 == 1:
                return False
            else:
                mask = 1 << value
                box[r][c] = box[r][c] | mask

    return True