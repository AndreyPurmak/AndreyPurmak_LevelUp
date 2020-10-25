package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignPositiveTest extends AbstractBaseTest {

    @Test(dataProvider = "PositiveData", dataProviderClass = DataProviderForTests.class)
    public void PositiveData(long a, Boolean expectedResult) {
        Assert.assertTrue(calculator.isPositive(a));
    }
}
