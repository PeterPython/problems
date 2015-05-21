# http://www.codewars.com/kata/who-won-the-election/train/python

def getWinner(listOfBallots):
  map = {}
  winning = ""
  max = 0;
  for cand in listOfBallots:
    if cand in map:
      map[cand] = map[cand]+1
    else:
      map[cand] = 1
    
    if map[cand] > max:
      max = map[cand]
      winning = cand
      
  if max > len(listOfBallots)/2:
    return winning
  else:
    return None