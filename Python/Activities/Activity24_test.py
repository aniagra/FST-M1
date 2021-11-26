import pytest

@pytest.mark.parametrize("earned,spent,expected",[(30,10,20),(20,2,18)])
def test_wallet(earned,spent,expected,wallet):
    wallet = wallet+earned

    wallet = wallet - spent

    assert wallet == expected