package UnitTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.levelup.qa.at.calculator.Calculator;

public abstract class AbstractBaseTest {

    public static Calculator calculator;

    @BeforeSuite
    public void setCalculator() {
        calculator = new Calculator();
    }

    @AfterSuite
    public void tearDownCalculator() {
        calculator = null;
    }
}
