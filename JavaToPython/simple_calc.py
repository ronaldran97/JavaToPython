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

