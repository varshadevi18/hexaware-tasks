public class Task5_TwoPointers {

    public static void main(String[] args) {

        // Sorted order values
        int[] orders = {
            100, 200, 300, 400,
            500, 600, 700, 800
        };

        int target = 900;

        int left = 0;
        int right = orders.length - 1;

        boolean found = false;

        System.out.println("TWO POINTERS");

        System.out.println("Gift Card Value: " + target);

        System.out.println("Matching pairs:");

        while (left < right) {

            int sum = orders[left] + orders[right];

            if (sum == target) {

                System.out.println(
                        orders[left] + " + "
                        + orders[right] + " = " + target);

                found = true;

                left++;
                right--;

            } else if (sum < target) {

                left++;

            } else {

                right--;
            }
        }

        if (!found) {
            System.out.println("No pairs found.");
        }
    }
}