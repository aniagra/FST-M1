user_tuple = tuple(input("Enter tuple:").split(","))
for item in user_tuple:
    if  (int(item) % 5 ==0):
        print(item)
    else:
        continue