package DataProviders;

import org.testng.annotations.DataProvider;

public class CommentsEndpointDataProvider {

    @DataProvider
    public Object[][] postCommentsDataProvider() {
        return new Object[][]{
                {"Andrey", "andreytesttest@mail.ru", "test", 120},
        };
    }

    @DataProvider
    public Object[][] getCommentsDataProvider() {
        return new Object[][]{
                {"123"},
        };
    }

    @DataProvider
    public Object[][] putCommentsDataProvider() {
        return new Object[][]{
                {"Andreyyyyyyy", "andreyyyyyyy@mail.ru", "test", 100, 110},
        };
    }

    @DataProvider
    public Object[][] deleteCommentsDataProvider() {
        return new Object[][]{
                {"126"},
        };
    }
}