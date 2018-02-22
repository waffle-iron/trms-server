package app.seeds;

import app.models.Role;
import app.models.User;
import com.github.javafaker.Faker;

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
                new Role("Employee"),
                "secret"
        );
    }

    public static Role createRole(String role) {
        return new Role(role);
    }
}
