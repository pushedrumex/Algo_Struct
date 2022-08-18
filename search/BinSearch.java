package search;

import java.util.Scanner;

public class BinSearch {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("요솟수 : "); int n = scan.nextInt();
        System.out.println("오름차순으로 입력하세요");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ",i);
            arr[i] = scan.nextInt();
        }
        System.out.print("찾아야할 값 : ");int num = scan.nextInt();
        int result = binSearch(arr, num);
        if (result == -1) System.out.println("해당 값이 존재하지 않습니다.");
        else System.out.printf("해당 요솟값은 arr[%d]에 존재합니다.\n",result);
        }

    static int binSearch(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] < num) start = mid + 1;
            else if (arr[mid] > num) end = mid - 1;
            else return mid;
        }
        return -1;
    }
}
