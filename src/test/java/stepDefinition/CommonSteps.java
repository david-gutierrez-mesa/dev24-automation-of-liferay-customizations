package stepDefinition;

import browserManager.DriverManager;
import portalObjects.users.RegisteredUser;

import java.net.MalformedURLException;
import java.net.URL;

import static browserManager.CommonMethods.*;
import static portalObjects.paths.FirstLoginPaths.*;
import static portalObjects.paths.GlobalPaths.LOG_OUT_URL;
import static portalObjects.paths.LoginPaths.SIGN_IN_LINK;
import static portalObjects.paths.PrivateLayoutPaths.STICKER_OVERLAY_LOCATOR;

public class CommonSteps {
    public static void fistLogin(RegisteredUser user, URL baseUrl) throws MalformedURLException {
        DriverManager.getDriver().get(baseUrl.toString());
        DriverManager.setImplicitWaitTime(0);
        if( !DriverManager.getDriver().findElements(SETUP_WIZARD).isEmpty()){
            DriverManager.resetImplicitWaitTime();
            inputText(ADMIN_EMAIL_ADDRESS, user.getEmail());
            click(FINISH_BUTTON);

            waitAndClick(ACCEPT_TERMS_AND_CONDITIONS);

            waitAndiInputText(FIRST_PASSWORD, user.getPassword());
            inputText(FIRST_PASSWORD_CONFIRMATION, user.getPassword());
            click(SAVE_CHANGE_PASSWORD);

            waitAndiInputText(REMINDER_QUESTION, user.getReminderQuestionAnswer());
            click(SAVE_REMINDER_QUESTION);

            waitForElementToBeVisible(STICKER_OVERLAY_LOCATOR);

            URL singOut = new URL(baseUrl, LOG_OUT_URL);
            DriverManager.getDriver().get(singOut.toString());

            waitForElementToBeVisible(SIGN_IN_LINK);

        } else {
            DriverManager.resetImplicitWaitTime();

        }

    }

    private CommonSteps() {
    }
}
