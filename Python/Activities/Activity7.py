elements = [1,2,3]
sum = 0
for i in elements:
    sum = sum + i
print(sum)
user_list = list(input("Enter the list for addition:").split(","))
sum = 0
for i in user_list:
    sum = sum + int(i)
print(sum)
    