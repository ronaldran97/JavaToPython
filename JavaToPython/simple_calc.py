"""
Every file should start with a description of what it is for
"""
# All functions should have a variable per line and a comma per line, this
# helps you edit functions or variables quickly in vim by quickly jumping to
# the exact variable you care about
def add(
        x: int, # You can define the data type in python3
        y: int,
) -> int: # You can also define the return type
    """
    Each Function should have a description of what they do

    :param x: This should tell me what x is
    :param y: This should tell me what y is
    :return int: this should tell me the type you return
    """

    total = x + y # sum is a keyword in python
    # I removed a line here that printed the same thing you were returning

    # Try to have a buffer line between normal statements and if/return statements
    return total
# 2 blank lines between functions (if not in a class)


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

# You can put your main logic in this function
def main():
    # use camel_case, and separate function parameters in lines
    input_x = input(
            'Enter your first value: ',
    )
    inputy = input('Enter your second value: ')
    print ('possible operators: +, -, /, *')
    operatorInp = input ('Enter your operator: ')

    # Don't need () around equalities in python
    if operatorInp == '+': 
        # If your parameter is a function, it's fine to only spread out it's
        # parameters like so
       print(add(
           input_x,
           inputy,
       ))
    elif (operatorInp == '-'):
        print(subtract(input_x, inputy))
    elif (operatorInp == '/'):
       print(divide(input_x, inputy))
    elif (operatorInp == '*'):
       print(multiply(input_x, inputy))
    else:
        # Your ( was not around the string
       print ('enter a valid operator') 

# This is a special identifier in python to check if you are calling this file
# directly
if __name__ == '__main__':
    main()
