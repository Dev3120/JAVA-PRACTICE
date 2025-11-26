public class llimplementation {

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static class llStack {
        Node head = null;
        int size = 0;

        void push(int x) {
            Node temp = new Node(x);
            temp.next = head;
            head = temp;
            size++;
        }

        int pop() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;
        }

        int peek() {
            if (head == null) {
                System.out.println("Stack is Empty");
                return -1;
            }
            return head.val;
        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " ");
                temp = temp.next;  // YOU MISSED THIS
            }
            System.out.println();
        }

        int size() {
            return size;
        }

        boolean isEmpty() {
            return size == 0;
        }
    }

    public static void main(String[] args) {
        llStack st = new llStack();  // Use your custom stack

        st.push(4);
        st.display();

        st.push(5);
        st.display();

        st.push(1);
        st.display();

        System.out.println("Size: " + st.size());

        st.pop();
        st.display();

        System.out.println("Top element: " + st.peek());

        st.push(7);
        st.push(0);
        st.display();

        System.out.println("Is empty? " + st.isEmpty());
    }
}
