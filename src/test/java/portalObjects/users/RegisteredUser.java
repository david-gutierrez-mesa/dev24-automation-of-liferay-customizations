package portalObjects.users;

import java.time.LocalDate;
import java.util.Locale;

public interface RegisteredUser {
    LocalDate getDateOfBirth();

    String getEmail();

    String getFirstName();

    String getLastName();

    Locale geLocale();

    String getMiddleName();

    String getPassword();

    String getReminderQuestionAnswer();

    String getScreenName();

}
