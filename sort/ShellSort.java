package sort;

import java.util.Scanner;

import static sort.Utils.print;
import static sort.Utils.swap;

public class ShellSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("쉘 정렬");
        System.out.print("요솟수 : ");

        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ", i);
            arr[i] = scan.nextInt();
        }

        System.out.println("오름차순 정렬");

        for (int h = n / 2; h > 0; h /= 2) {
            // 각 요소를 돌면서 증분값h을 바탕으로 삽입 정렬
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j])
                        swap(arr, j, j - h);
                    else break;
                }
            }
        }
        print(arr);
    }
}
