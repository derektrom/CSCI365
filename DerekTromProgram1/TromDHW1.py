'''
Derek Trom
derek.trom@und.edu
HW 1 CSCI 365
Random Num List Program
'''
import random

def getMin(array):
    minimum = array[0]
    for i in range(0,20):
        if array[i] < minimum:
            minimum = array[i]
    return minimum
def fillArray():
    array = []
    for i in range(0, 20):
        array.append(random.randint(0,100))
    return array
def getMax(array):
    maximum = array[0]
    for i in range(0,20):
        if array[i] > maximum:
            maximum = array[i]
    return maximum
def printArray(array):
    count = 0
    for i in array:
        count += 1
        print("%3d %3d" % (count, i))
def findAverage(array):
    summation = 0
    count = 0
    for i in array:
        count+= 1
        summation += i
    return summation/count
    

if __name__ == '__main__':
    
    randomArray = fillArray()
    minimum = getMin(randomArray)
    print("Minimum: %d" % minimum)
    maximum = getMax(randomArray)    
    print("Maximum: %d" % maximum)
    averageOfArray = findAverage(randomArray)
    print("Average: %.2f" % averageOfArray)
    print("Values")
    printArray(randomArray)
                
