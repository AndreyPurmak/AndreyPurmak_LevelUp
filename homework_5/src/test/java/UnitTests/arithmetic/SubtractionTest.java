package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtractionTest extends AbstractBaseTest {

    @Test(dataProvider = "SubLongData", dataProviderClass = DataProviderForTests.class)
    public void sub(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.sub(a,b), expectedResult);
    }

    @Test(dataProvider = "SubDoubleData", dataProviderClass = DataProviderForTests.class)
    public void sub(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.sub(a,b), expectedResult);
    }
}
