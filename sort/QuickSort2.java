package sort;

import stackAndQueue.IntStack;

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
        // 스택 생성
        IntStack lStack = new IntStack(arr.length); // 그룹의 왼쪽 끝 인덱스 저장
        IntStack rStack = new IntStack(arr.length); // 그룹의 오른쪽 끝 인덱스 저장

        lStack.push(pl);
        rStack.push(pr);

        while (!lStack.isEmpty()) {
            int left = pl = lStack.pop();
            int right = pr = rStack.pop();
            int pivot = arr[(pl + pr) / 2];

            while (pl <= pr) {
                while (arr[pl] < pivot) pl++;
                while (arr[pr] > pivot) pr--;

                if (pl <= pr) {
                    swap(arr, pl++, pr--);
                }
            }

            // 왼쪽 그룹
            if (left <= pr) {
                lStack.push(left);
                rStack.push(pr);
            }
            // 오른쪽 그룹
            if (pl < right) {
                lStack.push(pl);
                rStack.push(right);
            }
        }
    }
}
