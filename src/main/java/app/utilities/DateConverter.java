package app.utilities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateConverter {

    public static Timestamp dateToSQL(LocalDateTime localDateTime) {
        if (localDateTime != null) {
            return Timestamp.valueOf(localDateTime);
        }
        return null;
    }

    public static LocalDateTime dateToLocalDateTime(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        }
        return null;
    }
}
