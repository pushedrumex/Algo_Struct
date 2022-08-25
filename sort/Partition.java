package sort;

import java.util.Scanner;

import static sort.Utils.swap;

// 배열 나누기

public class Partition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("배열을 나눕니다.");
        System.out.print("요솟수 : ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }

        int pivot = arr[n/2];
        System.out.println("피벗의 값 : " + pivot);

        int pl = 0;
        int pr = n-1;

        // pl과 pr이 교차되면 멈춤
        while (pl <= pr){
            // 왼쪽부터 시작해 피벗 이상의 값을 찾을 때까지
            while (arr[pl] < pivot) pl++;

            // 오른쪽부터 시작해 피벗 이하의 값을 찾을 때까지
            while (arr[pr] > pivot) pr--;

            // 교환
            if (pl <= pr) // 범위 체크
                swap(arr, pl++, pr--);
        }

        System.out.println("왼쪽 그룹");
        for (int i = 0; i <= pr; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.println("오른쪽 그룹");
        for (int i = pl; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}
