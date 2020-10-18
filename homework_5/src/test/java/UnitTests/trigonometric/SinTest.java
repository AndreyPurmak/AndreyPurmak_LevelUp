package UnitTests.trigonometric;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SinTest extends AbstractBaseTest {

    @Test(dataProvider = "SinData", dataProviderClass = DataProviderForTests.class)
    public void sin(double a, double expectedResult) {
        Assert.assertEquals(calculator.sin(a), expectedResult, 0.01);
    }
}
