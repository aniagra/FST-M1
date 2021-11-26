fruit_dict = {
    "Apple": 100,
    "banana": 50
}
print(fruit_dict)
""" for fruit in fruit_dict:
    print(fruit)
for fruit in fruit_dict:
    print(fruit_dict[fruit]) """
user_input = input("Enter fruit name:").lower()
if user_input in fruit_dict:
    print(fruit_dict[user_input])
else:
    print("Entered fruit does not exist in the dictionary")