# http://www.codewars.com/kata/your-ride-is-here/python

def ride(group,comet):
    group_number = 1
    comet_number = 1
    for i in group:
        ascii = ord(i) - ord('A') + 1
        group_number *= ascii
        
    for i in comet:
        ascii = ord(i) - ord('A') + 1
        comet_number *= ascii
    
    if group_number%47 == comet_number%47:
        return 'GO'
    else:
        return 'STAY'