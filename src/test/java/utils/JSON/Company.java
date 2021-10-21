package utils.JSON;

import com.liferay.poshi.runner.util.JSONCurlUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static utils.JSON.Generic.*;

public class Company {
    private Company() {
    }

    public static String getCompanyId() throws IOException, TimeoutException {
        String portalInstanceName = getPortalInstanceName();

        String portalURL = getPortalURL();

        String curl = String.format("%sapi/jsonws/company/get-company-by-virtual-host/virtual-host/%s -u %s:%s", portalURL, portalInstanceName, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);

        return JSONCurlUtil.get(curl, "$['companyId']");
    }

}