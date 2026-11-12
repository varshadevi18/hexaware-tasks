public class Task4_SlidingWindow {

    public static void main(String[] args) {

        // Requests received every hour
        int[] requests = {
            100, 120, 150, 200, 250, 300,
            350, 400, 450, 500, 550, 600,
            650, 700, 750, 800, 850, 900,
            950, 1000, 1100, 1200, 1050, 1000
        };

        int k = 3;

        int sum = 0;

        // First 3-hour window
        for (int i = 0; i < k; i++) {
            sum += requests[i];
        }

        int maxSum = sum;
        int startHour = 0;

        // Sliding window
        for (int i = k; i < requests.length; i++) {

            sum = sum + requests[i] - requests[i - k];

            if (sum > maxSum) {

                maxSum = sum;

                startHour = i - k + 1;
            }
        }

        System.out.println("SLIDING WINDOW");

        System.out.println("Busiest 3-hour window: "
                + startHour + ":00 to "
                + (startHour + 3) + ":00");

        System.out.println("Maximum requests: " + maxSum);
    }
}