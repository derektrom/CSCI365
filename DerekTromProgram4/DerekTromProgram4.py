"""
Derek Trom
derek.trom@und.edu
Program 4
"""
import sys as system
from _collections import deque


def relOp(token):
    """
    check for relational op
    :param token: lexeme being tested
    :return: True if relational op else False
    """
    if "<rel>" in token:
        return True
    else:
        return False


def value(token):
    """
    check if a number or an id
    :param token: lexeme input
    :return: True if value else false
    """
    if "<number>" in token or "<id>" in token:
        return True
    else:
        return False


def boolean(token, queue,outfile):
    """
    checking boolean statements
    :param token: lexeme being input
    :param queue: the queue of lexemes
    :return: new queue after checking or error out
    """
    # if not a number or id
    if not value(token):
        outfile.write("Lexical Error: <boolean_expr>" + token)
        print("Lexical Error: <boolean_expr>", token)
        system.exit(0)
    else:
        token = queue.popleft()
        # if there is an operator
        if relOp(token):
            token = queue.popleft()
            # if not an id or number after comparison
            if not value(token):
                outfile.write("Lexical Error: <boolean_expr>"+ token)
                print("Lexical Error: <boolean_expr>", token)
                system.exit(0)
    return queue


def inputCheck(queue, outfile):
    """
    check if input correct
    :param queue: queue of lexemes
    :return: queue if it is id after input else error
    """
    token = queue.popleft()
    # check if id after input
    if "<id>" in token:
        return queue
    else:
        outfile.write("Lexical Error: <input> "+ token)
        print("Lexical Error: <input>", token)
        system.exit(0)


def checkPrint(queue, outfile):
    """
    check if print statement correct
    :param queue: current queue of lexemes
    :return: new queue after check or error out
    """
    token = queue.popleft()
    # check if id after print
    if "<id>" in token:
        return queue
    else:
        outfile.write("Lexical Error: <print> "+ token)
        print("Lexical Error: <print>", token)
        system.exit(0)


def checkID(queue, outfile):
    """
    check identifiers for assignment
    :param queue: current queue of lexemes
    :return: new queue after change or error out
    """
    token = queue.popleft()
    # check for assignment
    if "<assign>" in token:
        token = queue.popleft()
        # check if next token is a value
        if value(token):
            return queue
        else:
            outfile.write("Lexical Error <assignment>: "+ token)
            print("Lexical Error <assignment>: ", token)
            system.exit(0)
    else:
        outfile.write("Lexical Error <assignment>: "+ token)
        print("Lexical Error no <assignment>: ", token)
        system.exit(0)


def checkBegin(queue, outfile):
    """
    checking a begin for an end statement
    :param queue: current queue of lexemes
    :return: new queue without the first occurrence of end or error
    """
    # iterate and look for an end if there is a begin
    for i in queue:
        if "<end>" in i:
            queue.remove(i)  # remove first occurrence of end
            break
        elif "$$$" in i:  # if end of file reached before an end is found
            outfile.write("Lexical Error: No matching <end> statement before EOF while parsing")
            print("Lexical Error: No matching <end> statement before EOF while parsing")
            system.exit(0)
    return queue


def checkIF(queue, outfile):
    """
    checking if statements
    :param queue: current queue of lexemes
    :return: new queue
    """
    token = queue.popleft()
    queue = boolean(token, queue, outfile)  # check if boolean is correct
    if "<else>" in token:  # check for else after boolean
        return queue
    elif "<begin>" in token:  # check for a begin
        queue = checkBegin(queue)  # make sure there is an end in begin
        return queue
    else:  # only an if which is legal
        return queue


def statement(queue, outfile):
    """
    statement checker with various lexical checks
    :param queue: current queue of lexemes
    :return:
    """
    token = queue.popleft()
    # check if id
    if "<id>" in token:
        queue = checkID(queue, outfile)
    # check if input statement
    elif "<input>" in token:
        queue = inputCheck(queue, outfile)
    # check if print statement
    elif "<print>" in token:
        queue = checkPrint(queue, outfile)
    # check begin statement
    elif "<begin>" in token:
        queue = checkBegin(queue, outfile)
    # check end
    elif "<end>" in token:
        #if end is found before a begin error out
        outfile.write("Lexical Error: No matching <begin> before <end> while parsing")
        print("Lexical Error: No matching <begin> before <end> while parsing")
        system.exit(0)
    # check if statment for correctness
    elif "<if>" in token:
        queue = checkIF(queue, outfile)
    #check if token is syntax error from source code
    elif "<error>" in token:
        outfile.write("Syntax Error in file: "+ token)
        print("Syntax Error in file: ", token)
        system.exit(0)
    #EOF
    elif "$$$" in token:
        return queue

    return queue

def main():
    """
    main function to get file input and start parsing
    :return: None
    """
    try:
        filename = system.argv[1]  # get from command line
        file = open(filename, 'r')  # open file
        outfile = open ("outfile5.txt", 'w')
        queue = deque()  # initialize deque
        for line in file:
            line = line.strip()  # strip \n from line
            queue.append(line)  # add to queue
        queue.append("$$$")  # add to end for end of program
        while len(queue) != 0:  # while not empty
            queue = statement(queue, outfile)  # test statement
        outfile.write("\nDone parsing spaghetti code. Looks good!!\n")
        print("\nDone parsing spaghetti code. Looks good!!\n")
        file.close()
        outfile.close()

    except IOError:  # catch file error
        outfile.write('There was an error opening the file')
        print('There was an error opening the file: \'%s\''% filename)
        file.close()
        outfile.close()
        system.exit(0)


if __name__ == "__main__":
    main()


