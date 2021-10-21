package stepDefinition.privateLayouts;

import base.TestContext;
import io.cucumber.java8.En;
import portalObjects.layouts.PrivateLayout;
import portalObjects.pages.MyAmazingPage;

import static junit.framework.TestCase.assertTrue;

public class MyAmazingPageSteps implements En {

    private TestContext testContext;
    private PrivateLayout privateLayoutMyAmazingPage;

    public MyAmazingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.privateLayoutMyAmazingPage = this.testContext.getLayoutObjectManager().getPrivateLayoutMyAmazingPage();

        Then("^I can see my name$", () -> {
            String myName = testContext.getUser().getFirstName();
            assertTrue(((MyAmazingPage) this.privateLayoutMyAmazingPage.getPage()).getMyAmazingFragmentComponent().assertFirstNameIs(myName));
        });

        Then("^I can see my e-mail$", () -> {
            String myEmail = testContext.getUser().getEmail();
            assertTrue(((MyAmazingPage) this.privateLayoutMyAmazingPage.getPage()).getMyAmazingFragmentComponent().assertEmailIs(myEmail));
        });

    }

}
