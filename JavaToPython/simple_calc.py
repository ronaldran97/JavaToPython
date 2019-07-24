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

***************************************************************************************************

"""
This program will be a simple calculator (add, subtract, divide, multiply)
"""

def add(
        x: int,
        y: int,
) -> int:
    """
    This function will be the add operator

    :param x: x will act as the first addend
    :param y: y will act as the second addend
    :return int: the sum will be an integer
    """
    
    total = x + y
    
    return total


def subtract(
       x: int,
       y: int,
) -> int:
    """
    This function will be the subtraction operator

    :param x will be the minuend
    :param y will be the subtrahend
    :return int: the difference will be an integer
    """

    difference = x - y
   
    return difference


def divide(
        x: int,
        y: int,
) -> int:
    """
    This function will be the division operator

    :param x will be the divisor
    :param y will be the divident
    :return int: the quotient will be an int with a remainder
    """

    quotient = x / y
 
    if y == 0:
        print('undefined')

    return quotient

    remainder = x % y
    print (quotient + " r" + remainder + " is the quotient") 

    return quotient

def multiply(
        x: int, 
        y: int,
) -> int:
    """
    This funciton will be the multiplication operator
    
    :param x will be a factor
    :param y will be a factor
    :return int: the quotient will be an int with a remainder
    """

    product = x * y

    print (product + " is the product")

    return product 

def main():
    intput_x = input(
            'Enter your first value: ',
    )

    input_y = input(
            'Enter your second value: ',
    )

    print('Possible Operators: +, -, *, /')
    operator_input = input(
            'Enter your operator: '
    )

    if operator_input == '+':
        print(add(
            input_x,
            input_y,
        ))
    elif operator_input == '-':
        print(subtract(
            input_x,
            input_y,
        ))
    elif operator_input == '/':
        print(divide(
            input_x,
            input_y,
        ))
    elif operator_input == '*':
        print(multiply(
            input_x,
            input_y
        ))
    else:
        print('enter a valid operator')


if __name__ == '__main__':
        main()

