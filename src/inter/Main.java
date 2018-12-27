package inter;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = scanner.nextInt();
            Arrays.sort(a);

            if (n == 1)
                System.out.println("0 0");

            int minCount = 1;
            int min = Integer.MAX_VALUE;
            boolean minIs0 = false;
            for (int i = 0; i < n - 1; i++) {
                int distance = a[i + 1] - a[i];
                if (distance == 0) {
                    minIs0 = true;
                    break;
                }
                if (distance < min) {
                    min = distance;
                    minCount = 1;
                } else if (distance == min)
                    minCount++;
            }
            if (minIs0) {
                minCount = 0;
                int serial0Count = 0;
                for (int i = 0; i < n - 1; i++) {
                    int distance = a[i + 1] - a[i];
                    if (distance != 0) {
                        minCount += serial0Count * (serial0Count + 1) / 2;
                        serial0Count = 0;
                    } else
                        serial0Count++;
                }
                minCount += serial0Count * (serial0Count + 1) / 2;
            }

            long maxCount;
            if (a[0] == a[n - 1])
                maxCount = n * (n - 1) / 2;
            else {
                int i = 1;
                while (i < n && a[i] == a[0])
                    i++;
                int j = n - 2;
                while (j >= 0 && a[j] == a[n - 1])
                    j--;
                j = n - 1 - j;
                maxCount = i * j;
            }

            System.out.println(minCount + " " + maxCount);
        }
    }
}