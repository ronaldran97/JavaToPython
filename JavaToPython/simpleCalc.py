#add operator
def add(x, y):
    sum = x + y
    print (sum + ' is the sum')
    return sum

#subtract operator
def subtract(x, y):
    difference = x - y
    print (difference + ' is the difference')
    return difference

#divide operator
def divide(x, y):
    quotient = x / y 
    if y == 0:
        print('undefined')
    return quotient
    remainder = x % y
    print (quotient + " r" + remainder + " is the quotient") 
    return quotient

#multiplication operator
def multiply(x, y):
    product = x * y
    print (product + " is the product")
    return product 

inputx = input('Enter your first value: ')
inputy = input('Enter your second value: ')
print ('possible operators: +, -, /, *')
operatorInp = input ('Enter your operator: ')

if (operatorInp == '+'): 
   print(add(inputx, inputy))
elif (operatorInp == '-'):
    print(subtract(inputx, inputy))
elif (operatorInp == '/'):
   print(divide(inputx, inputy))
elif (operatorInp == '*'):
   print(multiply(inputx, inputy))
else:
   (print 'enter a valid operator')
