package utils.tools;

import java.net.MalformedURLException;
import java.net.URL;

public class SystemProperties {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String URL_PROPERTY = "url";
    private static final String CI_MODE_PROPERTY = "ci";

    private SystemProperties() {
    }

    public static boolean getCiModeProperty() {
        String ciModeProperty = System.getProperty(CI_MODE_PROPERTY);
        boolean ciMode = false;
        if (ciModeProperty != null && !ciModeProperty.isEmpty()) {
            ciMode = ciModeProperty.equalsIgnoreCase("true");
        }
        return ciMode;
    }

    public static String getBrowser() {
        return System.getProperty(BROWSER_PROPERTY);
    }

    public static URL getUrl() {
        URL generatedUrl = null;
        String url = System.getProperty(URL_PROPERTY);
        if (url != null && !url.isEmpty()) {
            url = url.toLowerCase();
            if (!url.endsWith("/")) url = url.concat("/");
            try {
                generatedUrl = new URL(url);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

        return generatedUrl;
    }

}
