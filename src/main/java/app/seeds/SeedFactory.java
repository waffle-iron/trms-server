package app.seeds;

import app.models.*;
import app.utilities.DaoUtility;
import com.github.javafaker.Faker;

import java.time.LocalDateTime;

public class SeedFactory {

    public static Faker fake() {
        return new Faker();
    }

    public static int number(int start, int end) {
        return fake().number().numberBetween(start, end);
    }

    public static User createUser() {
        return new User(
                fake().name().firstName(),
                fake().name().lastName(),
                fake().company().profession(),
                fake().internet().safeEmailAddress(),
                new Role(2, LocalDateTime.now(), LocalDateTime.now(), "Employee"),
                "secret"
        );
    }

    public static User createDbUser() {
        DaoUtility.getUserDao().create(createUser());
        return DaoUtility.getUserDao().fetch(1);
    }

    public static Role createRole(String role) {
        return new Role(role);
    }

    public static Reimbursement createReimbursement() {
        return new Reimbursement(
                new User(),
                new Event(),
                LocalDateTime.now(),
                false,
                LocalDateTime.now(),
                false,
                null,
                null,
                ""
        );
    }

    public static Event createEvent() {
        return new Event(
                new EventType(),
                LocalDateTime.now(),
                fake().address().cityName(),
                fake().lorem().sentence(),
                fake().lorem().sentence(),
                fake().number().numberBetween(100, 1000),
                new GradingFormat(),
                String.valueOf(fake().number().numberBetween(50, 100)),
                null,
                "",
                null
        );
    }

    public static EventType createEventType() {
        return new EventType(
                fake().beer().style(),
                fake().number().numberBetween(50, 100)
        );
    }

    public static GradingFormat createGradingFormat() {
        return new GradingFormat(
                fake().lorem().word(),
                fake().lorem().sentence()
        );
    }
}
