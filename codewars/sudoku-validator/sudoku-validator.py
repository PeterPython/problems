# http://www.codewars.com/kata/sudoku-solution-validator/python

def validSolution(board):
    rows = [0] * 9
    columns = [0] * 9
    box = [[0 for x in range(3)] for x in range(3)] 

    for i in range(0,9):
        for j in range(0,9):
            r = i/3
            c = j/3
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