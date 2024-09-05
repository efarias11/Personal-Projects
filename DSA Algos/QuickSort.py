import random

def printArray(nums): # function order matter, because they have to defined before being called
    for i in nums: # print out the tuple list on without whitespace indention
        print(str(i), end=" ") # use i so it prints each element once not size times
    print()

def swap(array, index1, index2):
    temp = array[index1]
    array[index1] = array[index2]
    array[index2] = temp

def quicksort(array, lowI, highI):
    if(lowI>=highI):
        return
    pivotIndex = random.randint(lowI, highI) 
    pivot = array[pivotIndex]
    swap(array, pivotIndex, highI)

    left_pointer = partition(array, lowI, highI, pivot)

    quicksort(array, lowI, left_pointer-1)
    quicksort(array, left_pointer + 1, highI)

def partition(array, lowI, highI, pivot):
    left_pointer = lowI
    right_pointer = highI - 1

    while(left_pointer<=right_pointer):
        while(array[left_pointer] <= pivot and left_pointer <= right_pointer):
            left_pointer += 1
        while(array[right_pointer] >= pivot and left_pointer <= right_pointer):
            right_pointer -= 1
        
        if left_pointer < right_pointer:
            swap(array, left_pointer, right_pointer)

    swap(array, left_pointer, highI)
    return left_pointer

size = 50
nums = [random.randint(1,1000) for l in range(size)] # we created a list with a given size and random nums range from 1 to 1000
print("Before: ")
printArray(nums)

quicksort(nums, 0, len(nums)-1)
print("After: ")
printArray(nums)
