package sort;

import java.util.Scanner;

import static sort.Utils.print;

public class MergeSort {
    static int[] temp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("병합 정렬");
        System.out.print("요솟수 : ");

        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }
        System.out.println("오름차순 정렬");

        // 병합한 결과를 일시적으로 저장할 배열
        temp = new int[n];

        // 배열 전체는 병합 정렬
        mergeSort(arr, 0, n-1);
        print(arr);
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right)  {
            int center = (left + right) / 2;
            int i;
            int p = 0;
            int j = 0;
            int k = left;

            // 배열의 앞부분 병합 정렬
            mergeSort(arr, left, center);
            // 배열의 뒷부분 병합 정렬
            mergeSort(arr, center+1, right);

            // 앞부분과 뒷부분 병합

            // 1. 배열의 앞부분을 temp에 복사
            for (i = left; i <= center; i++)
                temp[p++] = arr[i];

            // 2. 배열의 뒷부분과 temp를 배열 a에 병합
            while (i <= right && j < p)
                arr[k++] = temp[j] <= arr[i] ? temp[j++] : arr[i++];
            // 3. 배열에 temp의 나머지 요소를 복사
            while (j < p)
                arr[k++] = temp[j++];
        }
    }
}
