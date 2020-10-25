package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultiplicationTest extends AbstractBaseTest {

    @Test(dataProvider = "MtplLongData", dataProviderClass = DataProviderForTests.class)
    public void mult(long a, long b, long expectedResult) {
        Assert.assertEquals(calculator.mult(a,b), expectedResult);
    }

    @Test(dataProvider = "MtplDoubleData", dataProviderClass = DataProviderForTests.class)
    public void mult(double a, double b, double expectedResult) {
        Assert.assertEquals(calculator.mult(a,b), Math.floor(expectedResult));
    }
}
