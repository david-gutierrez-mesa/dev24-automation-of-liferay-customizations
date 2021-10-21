package portalObjects.users;

import java.time.LocalDate;
import java.util.Locale;

public class StandardUser implements RegisteredUser {

    @Override
    public LocalDate getDateOfBirth() {
        return LocalDate.of(1986, 8, 24);
    }

    @Override
    public String getEmail() {
        return "standarduser@liferay.com";
    }

    @Override
    public String getFirstName() {
        return "standarduser";
    }

    @Override
    public String getLastName() {
        return "standarduser";
    }

    @Override
    public Locale geLocale() {
        return new Locale("EN", "US");
    }

    @Override
    public String getMiddleName() {
        return null;
    }

    @Override
    public String getPassword() {
        return "test";
    }

    @Override
    public String getReminderQuestionAnswer() {
        return "test";
    }

    @Override
    public String getScreenName() {
        return "standarduser";
    }
}
