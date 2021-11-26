user_list = list(input("Enter the list:").split(","))
first_num = user_list[0]
print(first_num)
print(user_list[len(user_list)-1])
if user_list[0] == user_list[len(user_list)-1]:
    print("True")
else:
    print("False")