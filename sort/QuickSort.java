package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

// 퀵 정렬
public class QuickSort {
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
        quickSort(arr, 0, n - 1);
        print(arr);
    }

    static void quickSort(int[] arr, int pl, int pr){
        for(int i:arr) System.out.print(i + " ");
        System.out.println();
        int pivot = arr[(pr + pl) / 2];
        int left = pl;
        int right = pr;

        // pl과 pr이 교차되면 멈춤
        while (pl <= pr){
            // 왼쪽부터 시작해 피벗 이상의 값을 찾을 때까지
            while (arr[pl] < pivot) pl++;

            // 오른쪽부터 시작해 피벗 이하의 값을 찾을 때까지
            while (arr[pr] > pivot) pr--;

            // 교환
            if (pl <= pr) //  범위 체크
                swap(arr, pl++, pr--);
        }

        // 요소가 남아 있다면 재귀
        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }
}