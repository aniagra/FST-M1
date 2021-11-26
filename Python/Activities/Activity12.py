def sum(temp):
    if(temp >0):
        return temp + sum(temp-1)
    else:
        return 0
total = sum(10)
print(total)