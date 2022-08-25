package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

// 퀵 정렬 (비재귀)
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }
        System.out.println("오름차순 정렬");
        quickSort2(arr, 0, n - 1);
        print(arr);
    }

    static void quickSort2(int[] arr, int pl, int pr){
    }
}
