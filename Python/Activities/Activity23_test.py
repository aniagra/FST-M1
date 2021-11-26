import pytest


def sum_list(input_list):
    sum = 0
    for i in input_list:
        sum = sum + int(i)
    return sum

def test_listSum(input_list):
    total = sum_list(input_list)
    assert total == 55