package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtTest extends AbstractBaseTest {

    @Test(dataProvider = "SqrtData", dataProviderClass = DataProviderForTests.class)
    public void sqrt(double a, double expectedResult) {
        Assert.assertEquals(calculator.sqrt(a), expectedResult,  0.001);
    }
}
