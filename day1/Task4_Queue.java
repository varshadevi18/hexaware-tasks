
public class Task4_Queue {

    static class MyQueue {

        int[] queue = new int[100];
        int front = 0;
        int rear = -1;

        void enqueue(int token) {

            if (rear == queue.length - 1) {
                System.out.println("Queue Full");
                return;
            }

            queue[++rear] = token;
        }

        int dequeue() {

            if (front > rear) {
                System.out.println("Queue Empty");
                return -1;
            }

            return queue[front++];
        }

        void display() {

            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        MyQueue q = new MyQueue();

        System.out.println("TASK 4: PATIENT TOKEN QUEUE");

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Patient Tokens:");
        q.display();

        System.out.println("Serving Token: " + q.dequeue());

        System.out.println("Remaining Tokens:");
        q.display();
    }
}
