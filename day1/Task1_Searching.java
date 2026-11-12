
public class Task1_Searching {

    static int linearSearch(int[] patients, int target) {
        for (int i = 0; i < patients.length; i++) {
            if (patients[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] patients, int target) {
        int left = 0;
        int right = patients.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (patients[mid] == target) {
                return mid;
            }
            else if (patients[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] patients = new int[20000];

        for (int i = 0; i < patients.length; i++) {
            patients[i] = 1000 + i;
        }

        int target = 15999;

        long start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linearSearch(patients, target);
        }

        long linearTime = System.nanoTime() - start;

        start = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            binarySearch(patients, target);
        }

        long binaryTime = System.nanoTime() - start;

        System.out.println("TASK 1: SEARCHING");
        System.out.println("Linear Search: " + linearTime + " ns");
        System.out.println("Binary Search: " + binaryTime + " ns");
    }
}

