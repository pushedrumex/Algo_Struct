package basicDataStructures;

import java.util.Scanner;

// 배열 역순으로 정렬
public class ReverseArray {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("요솟수 : ");int size = scan.nextInt();
        int[] arr = new int[size];
        for (int i=0;i<size;i++){
            System.out.printf("x[%d] : ",i);arr[i] = scan.nextInt();
        }
        for (int i=0;i<size/2;i++){
            swap(arr, i, size-i-1);
        }

        System.out.println("요소를 역순으로 정렬했습니다.");

        for (int i=0;i<size;i++){
            System.out.printf("x[%d] : %d\n",i,arr[i]);
        }
    }
    static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}