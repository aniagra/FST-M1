
def fab(number):
    if number <=1:
        return number
    else:
        return (fab(number-1)+fab(number-2))
        
number = int(input("Enter the number: "))

for i in range(number):
        print(fab(i))
