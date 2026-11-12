
public class Task2_Sorting {

    static class Appointment {
        int patientId;
        int urgency;
        int arrivalTime;

        Appointment(int patientId, int urgency, int arrivalTime) {
            this.patientId = patientId;
            this.urgency = urgency;
            this.arrivalTime = arrivalTime;
        }

        public String toString() {
            return "Patient: " + patientId +
                   ", Urgency: " + urgency +
                   ", Arrival: " + arrivalTime;
        }
    }

    static int selectionSort(Appointment[] a) {
        int swaps = 0;

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < a.length; j++) {

                if (a[j].urgency < a[min].urgency ||
                   (a[j].urgency == a[min].urgency &&
                    a[j].arrivalTime < a[min].arrivalTime)) {
                    min = j;
                }
            }

            if (min != i) {
                Appointment temp = a[i];
                a[i] = a[min];
                a[min] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {

        Appointment[] appointments = {
            new Appointment(101, 3, 930),
            new Appointment(102, 1, 910),
            new Appointment(103, 2, 915),
            new Appointment(104, 1, 905),
            new Appointment(105, 3, 925)
        };

        int swaps = selectionSort(appointments);

        System.out.println("TASK 2: SORTING");
        System.out.println("Selection Sort Swaps: " + swaps);

        System.out.println("Sorted Appointments:");

        for (Appointment ap : appointments) {
            System.out.println(ap);
        }
    }
}

