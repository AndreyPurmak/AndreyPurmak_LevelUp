package DataProviders;

import org.testng.annotations.DataProvider;

public class UsersEndpointDataProvider {

    @DataProvider
    public Object[][] postUsersDataProvider() {
        return new Object[][] {
                {"Andrey", "andreytest@mail.ru", "Male", "Active"}
        };
    }

    @DataProvider
    public Object[][] getUserDataProvider() {
        return new Object[][] {
                {"1471"}
        };
    }

    @DataProvider
    public Object[][] putUserDataProvider() {
        return new Object[][] {
                {"Andreyyyyy", "andreyyyyy@mail.ru", "Male", "Active", "1471"}
        };
    }

    @DataProvider
    public Object[][] deleteUserDataProvider() {
        return new Object[][] {
                {"1435",}
        };
    }
}