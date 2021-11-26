import pytest

@pytest.mark.parametrize("num1, num2, expected", [(20, 10, 30), (15, 5,20), (9, 3,12)])
def testsum(num1,num2,expected): 
    num3 = num1 + num2
    assert num3 == expected


@pytest.mark.parametrize("num1, num2", [(20, 10), (15, 5), (9, 3)])
def test_difference(num1,num2):
    num3 = num1 - num2
    assert num3 == (num1-num2)


@pytest.mark.parametrize("num1, num2", [(20, 10), (15, 5), (9, 3)])
def testproduct(num1,num2):
    num3 = num1 * num2
    assert num3 == (num1*num2)


@pytest.mark.parametrize("num1, num2", [(20, 10), (15, 5), (9, 3)])
def test_quotient(num1,num2):
    num3 = num1 % num2
    assert num3 == (num1%num2)

