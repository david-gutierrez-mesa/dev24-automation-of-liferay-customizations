package portalObjects.paths;

import org.openqa.selenium.By;

public class FirstLoginPaths {

    public static final By ACCEPT_TERMS_AND_CONDITIONS = By.xpath("//*[@type='submit']/span");
    public static final By ADMIN_EMAIL_ADDRESS = By.xpath("//*[@id='adminEmailAddress']");
    public static final By FINISH_BUTTON = By.xpath("//*[@id='finishButton']");
    public static final By FIRST_PASSWORD = By.xpath("//*[@id='password1']");
    public static final By FIRST_PASSWORD_CONFIRMATION = By.xpath("//*[@id='password2']");
    public static final By REMINDER_QUESTION = By.xpath("//*[@id='reminderQueryAnswer']");
    public static final By SAVE_CHANGE_PASSWORD = By.xpath("//*[@type='submit']/span");
    public static final By SAVE_REMINDER_QUESTION = By.xpath("//*[@type='submit']/span");
    public static final By SETUP_WIZARD = By.xpath("//*[contains(@action,'setup_wizard') and @id='fm']");

    private FirstLoginPaths() {
    }

}
