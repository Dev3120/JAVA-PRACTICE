package JUSPAY;

import java.util.*;

public class sm {

    static Map<String, Integer> tollMap = new HashMap<>();

    // Add toll between nodes
    static void addToll(int from, int to, int cost) {
        tollMap.put(from + "->" + to, cost);
    }

    // Calculate total toll for given path
    static int getTollForPath(List<Integer> path) {
        int total = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String key = path.get(i) + "->" + path.get(i + 1);
            if (tollMap.containsKey(key)) {
                total += tollMap.get(key);
            } else {
                // If no direct toll exists between two cities, return 0
                return 0;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read number of toll connections
        int tollEntries = sc.nextInt();
        for (int i = 0; i < tollEntries; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            addToll(from, to, cost);
        }

        // Read number of queries
        int q = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        for (int i = 0; i < q; i++) {
            String[] parts = sc.nextLine().trim().split(" ");
            List<Integer> path = new ArrayList<>();

            for (String s : parts) {
                int node = Integer.parseInt(s);
                if (node == 0) break;
                path.add(node);
            }

            int toll = getTollForPath(path);
            System.out.println(toll);
        }

        sc.close();
    }
}
