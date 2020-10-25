package UnitTests.trigonometric;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TgTest extends AbstractBaseTest {

    @Test(dataProvider = "TgData", dataProviderClass = DataProviderForTests.class)
    public void tg(double a, double expectedResult) {
        Assert.assertEquals(calculator.tg(a), expectedResult, 0.01);
    }
}
