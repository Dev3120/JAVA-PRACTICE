package JUSPAY;

import java.util.*;

public class fmi {

    public static int solve(int P, int n, int[] o, int[] c) {
        int[] nextAvailable = new int[n]; // tracks when each machine will be available next
        int day = 0;
        int totalProduced = 0;

        while (totalProduced < P) {
            day++;

            for (int i = 0; i < n; i++) {
                if (nextAvailable[i] < day) { // machine is available today
                    totalProduced += o[i];
                    nextAvailable[i] = day + c[i]; // set next available day after maintenance
                }

                if (totalProduced >= P) break;
            }
        }

        return day;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int P = sc.nextInt(); // target production
        int n = sc.nextInt(); // number of machines

        int[] o = new int[n]; // output from each machine before maintenance
        for (int i = 0; i < n; i++) {
            o[i] = sc.nextInt();
        }

        int[] c = new int[n]; // cooldown days after production
        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        int result = solve(P, n, o, c);
        System.out.println(result);
    }
}

