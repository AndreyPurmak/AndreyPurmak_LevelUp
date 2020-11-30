package DataProviders;

import org.testng.annotations.DataProvider;

public class PostsEndpointDataProvider {

    @DataProvider
    public Object[][] postPostsDataProvider() {
        return new Object[][]{
                {"Test test", "testtesttest", 1433},
        };
    }

    @DataProvider
    public Object[][] getPostsDataProvider() {
        return new Object[][]{
                {"123"},
        };
    }

    @DataProvider
    public Object[][] putPostsDataProvider() {
        return new Object[][]{
                {"Test test test", "testtesttest", 134, 100},
        };
    }

    @DataProvider
    public Object[][] deletePostsDataProvider() {
        return new Object[][]{
                {"125"},
        };
    }
}