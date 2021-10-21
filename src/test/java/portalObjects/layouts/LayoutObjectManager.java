package portalObjects.layouts;

import portalObjects.pages.HomePage;
import portalObjects.pages.MyAmazingPage;

import java.net.URL;

public class LayoutObjectManager {
    private PublicLayout publicLayoutHomePage;
    private PrivateLayout privateLayoutHomePage;
    private PrivateLayout privateLayoutMyAmazingPage;

    private URL baseURL;

    public LayoutObjectManager(URL baseURL) {
        this.baseURL = baseURL;
    }

    public PublicLayout getPublicLayoutHomePage() {
        return (publicLayoutHomePage == null) ? publicLayoutHomePage = new PublicLayout(this.baseURL, new HomePage()) : publicLayoutHomePage;

    }

    public PrivateLayout getPrivateLayoutHomePage() {
        return (privateLayoutHomePage == null) ? privateLayoutHomePage = new PrivateLayout(this.baseURL, new HomePage()) : privateLayoutHomePage;

    }

    public PrivateLayout getPrivateLayoutMyAmazingPage() {
        return (privateLayoutMyAmazingPage == null) ? privateLayoutMyAmazingPage = new PrivateLayout(this.baseURL, new MyAmazingPage()) : privateLayoutMyAmazingPage;

    }

}
