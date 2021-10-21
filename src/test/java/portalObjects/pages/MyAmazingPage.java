package portalObjects.pages;

import portalObjects.components.MyAmazingFragmentComponent;
import portalObjects.pages.abstracts.PrivatePO;

public class MyAmazingPage extends PrivatePO {
    private MyAmazingFragmentComponent myAmazingFragmentComponent;

    public MyAmazingPage() {
        myAmazingFragmentComponent = new MyAmazingFragmentComponent();
    }

    @Override
    public String getPagePath() {
        return "group/guest/my-amazing-page/";
    }

    @Override
    public String getPageName() {
        return "My Amazing Page";
    }

    public MyAmazingFragmentComponent getMyAmazingFragmentComponent() {
        return myAmazingFragmentComponent;
    }

}
