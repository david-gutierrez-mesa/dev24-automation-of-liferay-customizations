package stepDefinition;

import base.TestContext;
import browserManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import portalObjects.users.RegisteredUser;
import portalObjects.users.UserFactory;
import portalObjects.users.UserTypes;

import java.net.MalformedURLException;

import static stepDefinition.CommonSteps.fistLogin;

public class BaseTest {
    private static boolean firstExecution = false;
    protected TestContext testContext;

    public BaseTest(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void setUp() throws MalformedURLException {
        if (!firstExecution) {
            Runtime.getRuntime().addShutdownHook(new Thread(DriverManager::quitDriver));

            RegisteredUser adminUser = UserFactory.getUser(UserTypes.ADMINISTRATOR);
            fistLogin(adminUser, testContext.getBaseUrl());

            firstExecution = true;

        }
    }

    @After
    public void tearDown() {
        DriverManager.getDriver().manage().deleteAllCookies();
        DriverManager.getDriver().navigate().refresh();
    }
}
