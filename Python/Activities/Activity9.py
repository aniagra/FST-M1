list1 = [1,2,3,4]
list2 = [5,6,7,8]
user_list1 = list(input("Enter list1:").split(","))
user_list2 = list(input("Enter list2:").split(","))
list3 = list(())
for num in user_list1:
    if int(num)%2==0:
        continue
    else:
        list3.append(num)
print(list3)
for num in user_list2:
    if int(num)%2==0:
        list3.append(num)
    else:
        continue
print(list3)
