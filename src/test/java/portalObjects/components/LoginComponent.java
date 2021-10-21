package portalObjects.components;

import portalObjects.layouts.PrivateLayout;
import portalObjects.pages.HomePage;
import portalObjects.users.RegisteredUser;

import java.net.URL;

import static browserManager.CommonMethods.*;
import static portalObjects.paths.LoginPaths.*;

public class LoginComponent {
    private URL baseUrl;

    public LoginComponent(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    public PrivateLayout doLogin(RegisteredUser user) {
        this.openLoginPopUp();
        inputText(NAME_FIELD_ID, user.getEmail());
        inputText(PASSWORD_FIELD_ID, user.getPassword());
        click(SIGN_IN_BUTTON);

        return new PrivateLayout(this.baseUrl, new HomePage());
    }

    public void openLoginPopUp() {
        click(SIGN_IN_LINK);
        waitForElementToBeVisible(NAME_FIELD_ID);
    }

}
