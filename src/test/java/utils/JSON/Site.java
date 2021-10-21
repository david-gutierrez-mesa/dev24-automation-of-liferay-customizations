package utils.JSON;

import com.liferay.poshi.runner.util.JSONCurlUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static utils.JSON.Company.getCompanyId;
import static utils.JSON.Generic.*;

public class Site {
    private Site() {
    }

    public static String getSiteId(String siteName) throws IOException, TimeoutException {
        String site = "true";
        String portalURL = getPortalURL();
        String companyId = getCompanyId();

        String curl = String.format("%sapi/jsonws/group/get-groups/company-id/%s/parent-group-id/0/site/%s -u %s:%s", portalURL, companyId, site, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);
        String jsonPath = String.format("$.[?(@['nameCurrentValue'] == '%s')]['groupId']", siteName);
        String groupId = JSONCurlUtil.get(curl, jsonPath);

        return groupId.replace("[\"", "").replace("\"]", "");

    }

}
