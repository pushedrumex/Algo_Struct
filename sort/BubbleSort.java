package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

// 버블 정렬
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("버블정렬");
        System.out.print("요솟수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            System.out.printf("arr[%d] : ",i);
            arr[i] = scan.nextInt();
        }
        System.out.println("오름차순 정렬");

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) swap(arr, j, j - 1);
            }
        }

//        // 개선(1) : 이미 정렬된 상태라면 정렬 작업을 멈춤
//        int flag;
//        for (int i = 0; i < n; i++) {
//            flag = 0;
//            for (int j = n - 1; j > i; j--) {
//                if (arr[j - 1] > arr[j]) swap(arr, j, j - 1);
//            }
//
//            // 정렬된 상태여서 교환한 적이 없다면
//            if (flag == 0) break;
//        }

//        // 개선(2) : 교환이 발생한 요소까지만 비교&교환
//        int index = 0;
//        int k = 0;
//
//        while (index < n - 1){ // index가 n-1이면 정렬 끝
//            index = n - 1;
//           for (int j = n - 1; j > k; j--) {
//                if (arr[j - 1] > arr[j]) swap(arr, j, j - 1);
//            }
//           k = index;
//        }
        print(arr);
    }
}
