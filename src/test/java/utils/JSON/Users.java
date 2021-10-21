package utils.JSON;

import com.liferay.poshi.runner.util.JSONCurlUtil;
import portalObjects.users.RegisteredUser;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static utils.JSON.Company.getCompanyId;
import static utils.JSON.Generic.*;
import static utils.JSON.Site.getSiteId;

public class Users {
    private Users() {
    }


    public static void addUserToASiteByEmail(String email, String siteName) throws IOException, TimeoutException {
        String userId = getUserIdByEmailAddress(email);
        String siteId = getSiteId(siteName);

        addUserToASite(userId, siteId);
    }

    public static void addUserToASite(String userId, String siteId) throws IOException, TimeoutException {
        String baseUrl = getPortalURL();

        String curl = String.format("%sapi/jsonws/user/add-group-users/group-id/%s/user-ids/%s -u %s:%s", baseUrl, siteId, userId, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);
        JSONCurlUtil.post(curl);
    }

    public static void agreeToTermsAndAnswerReminderQuery(String userId) throws IOException, TimeoutException {
        String baseUrl = getPortalURL();

        String curl = String.format("%sapi/jsonws/user/update-agreed-to-terms-of-use/user-id/%s/agreed-to-terms-of-use/true -u %s:%s", baseUrl, userId, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);
        JSONCurlUtil.post(curl);

        curl = String.format("%sapi/jsonws/user/update-reminder-query/user-id/%s/question/what-is-your-father%%27s-middle-name/answer/test t-u %s:%s", baseUrl, userId, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);
        JSONCurlUtil.post(curl);
    }

    public static void createUser(RegisteredUser user) throws IOException, TimeoutException {
        String requestURL = getPortalURL() + "api/jsonws/user/add-user";

        String companyId = getCompanyId();

        String curl = requestURL + " " +
                "-u " + ADMIN_USER_EMAIL + ":" + ADMIN_USER_PASSWORD + " " +
                "-d companyId=" + companyId + " " +
                "-d autoPassword=false " +
                "-d password1=" + user.getPassword() + " " +
                "-d password2=" + user.getPassword() + " " +
                "-d autoScreenName=false " +
                "-d screenName=" + user.getScreenName() + " " +
                "-d emailAddress=" + user.getEmail() + " " +
                "-d facebookId=0 " +
                "-d openId= " +
                "-d locale=" + user.geLocale().getCountry() + " " +
                "-d firstName=" + user.getFirstName() + " " +
                "-d middleName=" + user.getMiddleName() + " " +
                "-d lastName=" + user.getLastName() + " " +
                "-d prefixId=0 " +
                "-d suffixId=0 " +
                "-d male=true " +
                "-d birthdayMonth=" + user.getDateOfBirth().getMonthValue() + " " +
                "-d birthdayDay=" + user.getDateOfBirth().getDayOfMonth() + " " +
                "-d birthdayYear=" + user.getDateOfBirth().getYear() + " " +
                "-d jobTitle= " +
                "-d groupIds= " +
                "-d organizationIds= " +
                "-d roleIds= " +
                "-d userGroupIds= " +
                "-d sendEmail=false";

        JSONCurlUtil.post(curl);

        disablePasswordChangeRequired(companyId);

        String userId = getUserIdByEmailAddress(user.getEmail());
        agreeToTermsAndAnswerReminderQuery(userId);
    }

    public static void deleteUser(RegisteredUser user) throws IOException, TimeoutException {

        String userId = getUserIdByEmailAddress(user.getEmail());

        deleteUserByUserId(userId);

    }

    public static void deleteUserByUserId(String userId) throws IOException, TimeoutException {
        String baseUrl = getPortalURL();

        String curl = String.format("%sapi/jsonws/user/delete-user -u %s:%s -d userId=%s", baseUrl, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD, userId);

        JSONCurlUtil.post(curl);

    }

    public static void disablePasswordChangeRequired(String companyId) throws IOException, TimeoutException {
        String baseUrl = getPortalURL();

        //For 7.3 and older
        String curl = String.format("%sapi/jsonws/passwordpolicy/search/company-id/%s/name/default/start/0/end/1/-obc -u %s:%s", baseUrl, companyId, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);

        //For 7.4 and newer
        //        String curl = String.format("%sapi/jsonws/passwordpolicy/search " +
        //                        "-u %s:%s " +
        //                        "-d companyId=%s " +
        //                        "-d \"name=Default%%20Password%%20Policy\" " +
        //                        "-d \"start=-1\" " +
        //                        "-d \"end=-1\" " +
        //                        "-d -orderByComparator=",
        //                baseUrl, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD, companyId);

        String passwordPolicyId = JSONCurlUtil.post(curl, "$.[?(@['name'] == 'Default Password Policy')]['passwordPolicyId']");

        passwordPolicyId = passwordPolicyId.replace("[\"", "").replace("\"]", "");

        curl = baseUrl + "api/jsonws/passwordpolicy/update-password-policy " +
                "-u " + ADMIN_USER_EMAIL + ":" + ADMIN_USER_PASSWORD + " " +
                "-d passwordPolicyId=" + passwordPolicyId + " " +
                "-d name='Default Password Policy' " +
                "-d description='Default Password Policy' " +
                "-d changeable=false " +
                "-d changeRequired=false " +
                "-d minAge=0 " +
                "-d checkSyntax=false " +
                "-d allowDictionaryWords=true " +
                "-d minAlphanumeric=0 " +
                "-d minLength=6 " +
                "-d minLowerCase=0 " +
                "-d minNumbers=1 " +
                "-d minSymbols=0 " +
                "-d minUpperCase=1 " +
                "-d regex=\"(?=.{4})(?:[a-zA-Z0-9]*)\" " +
                "-d history=false " +
                "-d historyCount=6 " +
                "-d expireable=false " +
                "-d maxAge=8640000 " +
                "-d warningTime=86400 " +
                "-d graceLimit=0 " +
                "-d lockout=false " +
                "-d maxFailure=3 " +
                "-d lockoutDuration=0 " +
                "-d resetFailureCount=600 " +
                "-d resetTicketMaxAge=86400";

        JSONCurlUtil.post(curl);
    }

    public static String getUserIdByEmailAddress(String emailAddress) throws IOException, TimeoutException {
        String baseUrl = getPortalURL();

        String companyId = getCompanyId();

        String curl = String.format("%sapi/jsonws/user/get-user-by-email-address/company-id/%s/email-address/%s -u %s:%s", baseUrl, companyId, emailAddress, ADMIN_USER_EMAIL, ADMIN_USER_PASSWORD);

        return JSONCurlUtil.get(curl, "$['userId']");
    }
}
