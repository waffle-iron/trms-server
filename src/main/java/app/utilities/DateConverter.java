package app.utilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateConverter {

    public static Timestamp dateToSQL(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }

    public static LocalDateTime dateToLocalDateTime(Timestamp timestamp) {
        return timestamp.toLocalDateTime();
    }
}
