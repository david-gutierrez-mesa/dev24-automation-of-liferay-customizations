package portalObjects.components;

import static browserManager.CommonMethods.getTextFromElement;
import static portalObjects.paths.MyAmazingFragmentPaths.EMAIL_LOCATOR;
import static portalObjects.paths.MyAmazingFragmentPaths.FIRST_NAME_LOCATOR;

public class MyAmazingFragmentComponent {

    public MyAmazingFragmentComponent() {

    }

    public boolean assertEmailIs(String expectedEmail) {
        String actualEmail = getTextFromElement(EMAIL_LOCATOR);
        return expectedEmail.equals(actualEmail);
    }

    public boolean assertFirstNameIs(String expectedName) {
        String actualName = getTextFromElement(FIRST_NAME_LOCATOR);
        return expectedName.equals(actualName);
    }

}
