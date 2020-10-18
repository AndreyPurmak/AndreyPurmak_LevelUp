package UnitTests.trigonometric;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CtgTest extends AbstractBaseTest {

    @Test(dataProvider = "CtgData", dataProviderClass = DataProviderForTests.class)
    public void ctg(double a, double expectedResult) {
        Assert.assertEquals(calculator.ctg(a), expectedResult, 0.01);
    }
}
