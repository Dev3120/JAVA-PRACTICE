public class basis {
    // Node class definition
    public static class Node {
        int data;
        Node next;  // Reference to the next node

        // Constructor to initialize node data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Creating nodes
        Node a = new Node(5);
        Node b = new Node(3);
        Node c = new Node(9);
        Node d = new Node(8);
        Node e = new Node(16);

        // Linking nodes
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        // Print the linked list
        printLinkedList(a);
    }

    // Method to print the linked list
    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
 