package sort;

import java.util.Scanner;

import static sort.Utils.print;

public class HeapSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.println("요솟 수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }
        // arr 배열의 힙정렬
        heapSort(arr, n);
        System.out.println("오름차순 정렬");
        print(arr);
    }

    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    static void makeHeap(int[] arr, int parent, int end) {
        int value = arr[parent]; // 현재 값
        int left = parent * 2 + 1;
        int right = left + 1;

        while (left <= end) {
            int child = left; // 자식 중에 큰 값의 인덱스

            // 오른쪽 자식도 범위내에 존재하면서 왼쪽 자식보다 크다면
            if (right <= end && arr[right] > arr[child]) {
                child = right;
            }
            if (value < arr[child]) {
                swap(arr, parent, child);
                parent = child;
                left = parent * 2 + 1;
                right = left + 1;
            } else {
                break;
            }
        }
    }

    static void heapSort(int[] arr, int n) {
        // 마지막 요소의 부모 : (n-1)/2
        // 마지막 요소의 부모부터 출발하여 루트까지 힙 생성
         for (int i = (n - 1) / 2; i >= 0; i--) {
             makeHeap(arr, i, n - 1);
         }
         // 루트요소(가장큰수)와 맨 오른쪽 리프를 교환하며 힙 생성
        for (int i = n - 1; i >0; i--) {
            swap(arr, 0, i);
            makeHeap(arr, 0, i - 1);
        }
    }
}
