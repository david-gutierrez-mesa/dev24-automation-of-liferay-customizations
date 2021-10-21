package portalObjects.layouts;

import portalObjects.components.LoginComponent;
import portalObjects.pages.abstracts.PublicPO;

import java.net.URL;

public class PublicLayout extends LiferayLayout {

    private LoginComponent loginComponent;

    public PublicLayout(URL baseUrl, PublicPO pageObject) {
        super(baseUrl);
        loginComponent = new LoginComponent(baseUrl);
        page = pageObject;
    }


    //
    // Common Page Parts when not logged in by composition
    //

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

}
