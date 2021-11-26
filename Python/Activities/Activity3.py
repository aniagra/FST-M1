player1 = input("Enter player1's name: ")
player2 = input("Enter player2's name: ")
player1Choice = input("Choose either paper or scissors or rock:").lower()
player2Choice = input("Choose either paper or scissors or rock:").lower()
if player1Choice == player2Choice:
    print("It's a tie! Try again")
elif (player1Choice == "paper"):
    if (player2Choice == "rock"):
        print(player1 +" is a winner who choose " + player1Choice + " over " + player2Choice) 
    else:
        print(player2 +" is a winner who choose " + player2Choice + " over " + player1Choice) 
elif (player1Choice == "scissors"):
    if (player2Choice == "rock"):
        print(player2 +" is a winner who choose " + player2Choice + " over " + player1Choice) 
    else:
        print(player1 +" is a winner who choose " + player1Choice + " over " + player2Choice) 
elif (player1Choice == "rock"):
    if (player2Choice == "paper"):
        print(player2 +" is a winner who choose " + player2Choice + " over " + player1Choice) 
    else:
        print(player1 +" is a winner who choose " + player1Choice + " over " + player2Choice) 
else:
    print("Invalid data entered")