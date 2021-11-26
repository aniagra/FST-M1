def sum(numbers):
    temp = 0
    for num in numbers:
        temp = temp + int(num)
    print (temp)
    return temp
user_list = list(input("Enter list:").split(","))
total = sum(user_list)
print("Sum of the list:" + str(total))