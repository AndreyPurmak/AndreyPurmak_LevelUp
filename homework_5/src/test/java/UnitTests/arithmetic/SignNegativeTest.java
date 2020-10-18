package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignNegativeTest extends AbstractBaseTest {

    @Test(dataProvider = "NegativeData", dataProviderClass = DataProviderForTests.class)
    public void NegativeData(long a, Boolean expectedResult) {
        Assert.assertTrue(calculator.isNegative(a));
    }
}
