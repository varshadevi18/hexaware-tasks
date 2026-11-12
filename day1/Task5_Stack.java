
public class Task5_Stack {

    static class MyStack {

        int[] stack = new int[100];
        int top = -1;

        void push(int patientId) {

            if (top == stack.length - 1) {
                System.out.println("Stack Full");
                return;
            }

            stack[++top] = patientId;
        }

        int pop() {

            if (top == -1) {
                System.out.println("Stack Empty");
                return -1;
            }

            return stack[top--];
        }

        int peek() {

            if (top == -1) {
                return -1;
            }

            return stack[top];
        }
    }

    public static void main(String[] args) {

        MyStack st = new MyStack();

        System.out.println("TASK 5: RECENT PATIENT HISTORY");

        st.push(101);
        st.push(102);
        st.push(103);

        System.out.println("Most Recent Patient: " + st.peek());

        System.out.println("Removed Patient: " + st.pop());

        System.out.println("Current Most Recent Patient: " + st.peek());
    }
}

