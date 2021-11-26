import pytest

@pytest.fixture
def input_list():
    #list = [0,1,2,3,4,5,6,7,8,9,10]
    #list = list(input("Enter your list:").split(",")) # execute using -s in cmd
    list1 = list(range(11))
    return list1

@pytest.fixture
def wallet():
    amount = 0
    return amount