package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

// 단순 선택 정렬
public class SelectionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단순선택정렬");
        System.out.print("요솟수 : ");

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }

        System.out.println("오름차순 정렬");

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            swap(arr, i, min);
        }
        print(arr);
    }
}
