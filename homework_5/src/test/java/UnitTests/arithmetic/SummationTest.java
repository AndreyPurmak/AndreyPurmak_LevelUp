package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SummationTest extends AbstractBaseTest {

    @Test(dataProvider = "SumLongData", dataProviderClass = DataProviderForTests.class)
    public void sum(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.sum(a,b), expectedResult);
    }

    @Test(dataProvider = "SumDoubleData", dataProviderClass = DataProviderForTests.class)
    public void sum(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.sum(a,b), expectedResult);
    }
}
