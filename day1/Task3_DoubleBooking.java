
import java.util.*;

public class Task3_DoubleBooking {

    static class Appointment {
        int patientId;
        int startTime;
        int endTime;

        Appointment(int patientId, int startTime, int endTime) {
            this.patientId = patientId;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    static class BookingKey {
        int patientId;
        int startTime;
        int endTime;

        BookingKey(int patientId, int startTime, int endTime) {
            this.patientId = patientId;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof BookingKey)) {
                return false;
            }

            BookingKey other = (BookingKey) obj;

            return patientId == other.patientId &&
                   startTime == other.startTime &&
                   endTime == other.endTime;
        }

        public int hashCode() {
            return Objects.hash(patientId, startTime, endTime);
        }
    }

    static boolean detectDuplicate(Appointment[] a) {

        HashSet<BookingKey> booked = new HashSet<>();

        for (Appointment ap : a) {

            BookingKey key = new BookingKey(
                ap.patientId, ap.startTime, ap.endTime
            );

            if (!booked.add(key)) {
                System.out.println("Double booking detected: "
                                   + ap.patientId);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Appointment[] bookings = {
            new Appointment(201, 900, 930),
            new Appointment(202, 930, 960),
            new Appointment(201, 900, 930)
        };

        System.out.println("TASK 3: DOUBLE BOOKING");

        boolean result = detectDuplicate(bookings);

        System.out.println("Duplicate Found: " + result);
    }
}
