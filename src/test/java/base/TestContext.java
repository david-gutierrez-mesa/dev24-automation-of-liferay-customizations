package base;

import portalObjects.layouts.LayoutObjectManager;
import portalObjects.users.RegisteredUser;

import java.net.MalformedURLException;
import java.net.URL;

import static utils.tools.SystemProperties.getUrl;

public class TestContext {
    private static final String DEFAULT_URL = "http://localhost:8080/";

    private URL baseUrl;
    private RegisteredUser user;

    private LayoutObjectManager layoutObjectManager;

    public TestContext() throws MalformedURLException {
        URL url = getUrl();
        if (url == null) {
            url = new URL(DEFAULT_URL);

        }
        this.baseUrl = url;
        layoutObjectManager = new LayoutObjectManager(this.baseUrl);

    }

    public URL getBaseUrl() {
        return this.baseUrl;
    }

    public RegisteredUser getUser() {
        return user;
    }

    public void setUser(RegisteredUser user) {
        this.user = user;
    }

    public LayoutObjectManager getLayoutObjectManager() {
        return layoutObjectManager;
    }
}