import random
import time

words = [['F','O','X'],['L','O','C','K'],['A','M','A','Z','I','N','G'],['T','E','R','M','I','N','A','L'],['C','O','W'],['P','Y','T','H','O','N'],['T','R','E','E'],['H','E','L','L','O',' ','W','O','R','L','D']]
a = [[' ','+',' ','-',' ','-',' ','-',' ','+'],[' ',' ',' ',' ',' ',' ',' ',' ',' ','|'],[' ',' ',' ',' ',' ',' ',' ',' ',' ','|'],[' ',' ',' ',' ',' ',' ',' ',' ',' ','|'],[' ',' ',' ',' ',' ',' ',' ',' ','=','=','=']]

chance = 0

def hungman():
    for i in a:
        for j in i:
            print(j,end='')
        print()

def edithung(l):
    if l == 0:
        a[1][1] = 'O'
    elif l == 1:
        a[2][0] = '/'
    elif l == 2:
        a[2][1] = '|'
    elif l == 3:
        a[2][2] = '\\'
    elif l == 4:
        a[3][0] = '/'
    elif l == 5:
        a[3][2] = '\\'

def pword():
    for i in l:
        print(i + ' ',end ='')
    
    
l = []
w = random.choice(words)

for i in range(len(w)):
    l.append('_')
    
if len(w) <= 5:
    l[0] = w[0]
    chance = 6
    
    q = 0
    
elif len(w) > 5 and len(w) < 9 :
    l[1] = w[1]  
    l[-1] = w[-1]
    
    chance = 10
    
    q = -4

else :
    l[2] = w[2]
    l[9] = w[9]
    l[0] = w[0]
    



def checkwin(p):
    return "".join(p) == "".join(w)


print("\n\t\t XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")
print("\t\t XXX    THE HUNGMAN GAME    XXX")
print("\t\t XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX")

start = input("\n\tPress ENTER to begin : ")
print("\nLoading.",end ='')


for i in range(4):
    time.sleep(0.4)
    print(".",end ='')


chance1 = chance

while(1):
    print("\t\t\t\t\tChances remaining  : ",chance1)
    
    print("\t\t",end='')
    pword()

    u = input("\n\nEnter your guess :").upper()
    print()

    if u in w:
        for i in range(len(w)):
            if w[i] == u:
                l[i] = u
                chance += 1 
    else :
        edithung(q)
        chance1 -= 1
        q += 1
        
    m = checkwin(l)
    
    if m == True :
        print("\t\t\t\t\tChances remaining  : ",chance1)
        hungman()  
        print("\nYou guessed the word !")
        break
        
    elif q == 6:
        print("\t\t\t\t\tChances remaining  : ",chance1)
        hungman()       
        print("You Lost !")
        chance1 = chance
        break
    
    hungman()