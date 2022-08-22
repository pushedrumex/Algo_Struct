package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

// 단순 삽입 정렬
public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("단순삽입정렬");
        System.out.print("요솟수 : ");

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }

        System.out.println("오름차순 정렬");

        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                // 나보다 작거나 같은 값을 만날때까지 왼쪽으로 이동
                if (arr[j - 1] > arr[j])
                    swap(arr, j - 1, j);
                else break;
            }
        }
        print(arr);
    }
}
