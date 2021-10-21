package stepDefinition.privateLayouts;

import base.TestContext;
import io.cucumber.java8.En;
import portalObjects.layouts.PrivateLayout;

import static junit.framework.TestCase.assertTrue;

public class HomePageSteps implements En {

    private TestContext testContext;
    private PrivateLayout privateLayoutHomePage;

    public HomePageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.privateLayoutHomePage = this.testContext.getLayoutObjectManager().getPrivateLayoutHomePage();

        When("^I navigate to \"([^\"]*)\"$", (String page) -> {
            this.privateLayoutHomePage.navigateToPage(page);
            assertTrue(this.privateLayoutHomePage.getPage().assertPageIsCorrect());
        });

    }

}
