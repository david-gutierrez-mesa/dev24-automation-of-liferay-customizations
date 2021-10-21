package portalObjects.users;

public class UserFactory {
    public static RegisteredUser getUser(UserTypes userRole) {
        RegisteredUser user = null;

        switch (userRole) {
            case ADMINISTRATOR:
                user = new AdminUser();
                break;
            case STANDARD_USER:
                user = new StandardUser();
                break;
        }

        return user;
    }

}
