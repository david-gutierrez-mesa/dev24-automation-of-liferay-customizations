package portalObjects.paths;

import org.openqa.selenium.By;

public class LoginPaths {

    public static final By NAME_FIELD_ID = By.xpath("//*[@id='_com_liferay_login_web_portlet_LoginPortlet_login']");
    public static final By PASSWORD_FIELD_ID = By.xpath("//*[@id='_com_liferay_login_web_portlet_LoginPortlet_password']");
    public static final By SIGN_IN_BUTTON = By.xpath("//*[@class='lfr-btn-label']");
    public static final By SIGN_IN_LINK = By.xpath("//a[contains(@id,'_com_liferay_product_navigation_user_personal_bar_web_portlet_ProductNavigationUserPersonalBarPortlet_')]");

    private LoginPaths() {
    }

}
