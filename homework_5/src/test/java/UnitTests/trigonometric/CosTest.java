package UnitTests.trigonometric;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CosTest extends AbstractBaseTest {

    @Test(dataProvider = "CosData", dataProviderClass = DataProviderForTests.class)
    public void cos(double a, double expectedResult) {
        Assert.assertEquals(calculator.cos(a), expectedResult, 0.01);
    }
}
