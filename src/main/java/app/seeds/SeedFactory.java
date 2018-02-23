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
        return DaoUtility.getUserDao().create(new User(
                fake().name().firstName(),
                fake().name().lastName(),
                fake().company().profession(),
                fake().internet().safeEmailAddress(),
                createRole().getId(),
                "secret"
        ));
    }

    public static User createDbUser() {
        User u = DaoUtility.getUserDao().create(createUser());
        u.setDirectSupervisorId(createUser().getId());
        u.setDepartmentHeadId(createUser().getId());
        return u;
    }

    public static Role createRole() {
        return DaoUtility.getRoleDao().create(new Role(fake().lorem().word()));
    }

    public static Reimbursement createReimbursement(int userId) {
        return new Reimbursement(
                userId,
                createEvent().getId(),
                LocalDateTime.now(),
                false,
                LocalDateTime.now(),
                false,
                null,
                null,
                fake().lorem().sentence()
        );
    }

    public static Event createEvent() {
        return new Event(
                createEventType().getId(),
                LocalDateTime.now(),
                fake().address().cityName(),
                fake().lorem().sentence(),
                fake().lorem().sentence(),
                fake().number().numberBetween(100, 1000),
                createGradingFormat().getId(),
                String.valueOf(fake().number().numberBetween(50, 100)),
                null,
                createStatus().getId(),
                null
        );
    }

    public static EventType createEventType() {
        return DaoUtility.getEventTypeDao().create(new EventType(
                fake().beer().style(),
                fake().number().numberBetween(50, 100)
        ));
    }

    public static GradingFormat createGradingFormat() {
        return DaoUtility.getGradingFormatDao().create(new GradingFormat(
                fake().lorem().word(),
                fake().lorem().sentence()
        ));
    }

    public static Status createStatus() {
        return DaoUtility.getStatusDao().create(new Status(
                fake().lorem().word(),
                fake().lorem().sentence()
        ));
    }
}
