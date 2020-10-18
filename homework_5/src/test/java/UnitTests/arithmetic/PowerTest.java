package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PowerTest extends AbstractBaseTest {

    @Test(dataProvider = "PowData", dataProviderClass = DataProviderForTests.class)
    public void pow(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.pow(a,b), expectedResult, 0.001);
    }
}
