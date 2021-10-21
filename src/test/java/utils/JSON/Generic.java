package utils.JSON;

import com.liferay.poshi.runner.util.PropsUtil;

import java.net.URL;

import static utils.tools.SystemProperties.getUrl;

public class Generic {
    static final String ADMIN_USER_EMAIL = "test@liferay.com";
    static final String ADMIN_USER_PASSWORD = "test";

    private Generic() {
    }

    public static String getPortalURL() {
        URL url = getUrl();
        if (url == null) {
            return PropsUtil.get("portal.url").concat("/");
        }

        return url.toString();

    }

    public static String getPortalInstanceName() {
        String testPortalInstance = PropsUtil.get("test.portal.instance");

        if ("true".equals(testPortalInstance)) {
            String portalURL = getPortalURL();
            return portalURL.replace("http://", "").replace(":8080/", "");
        } else {
            return "localhost";
        }

    }

}
