package UnitTests.arithmetic;

import UnitTests.AbstractBaseTest;
import UnitTests.DataProviderForTests;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivisionTest extends AbstractBaseTest {

    @Test(dataProvider = "DivLongData", dataProviderClass = DataProviderForTests.class)
    public void div (long a, long b,  double expectedResult) {
        Assert.assertEquals(calculator.div(a,b), expectedResult);
    }

    @Test(dataProvider = "DivDoubleData", dataProviderClass = DataProviderForTests.class)
    public void div(double a, double b, double expectedResult) {
        System.out.println("Частное от деления чисел: " + a + " / " +b + " = " + expectedResult);
        Assert.assertEquals(calculator.div(a,b), expectedResult);
    }
}
