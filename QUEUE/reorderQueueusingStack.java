import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reorderQueueusingStack {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println("Original Queue: " + q);

        Stack<Integer> st = new Stack<>();
        int n = q.size();

        // Step 1: Push first half into stack
        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }

        // Step 2: Enqueue stack elements back to queue (reversed first half now at rear)
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // Step 3: Move first half (which was originally second half) to back
        for (int i = 1; i <= n / 2; i++) {
            q.add(q.remove());
        }

        // Step 4: Push first half (originally reversed first half) into stack again
        for (int i = 1; i <= n / 2; i++) {
            st.push(q.remove());
        }

        // Step 5: Interleave stack and queue
        for (int i = 1; i <= n / 2; i++) {
            q.add(st.pop());
            q.add(q.remove());
        }

        // Step 6: Reverse the final queue to get correct order
        while (!q.isEmpty()) {
            st.push(q.remove());
        }

        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        System.out.println("Reordered Queue: " + q);
    }
}
