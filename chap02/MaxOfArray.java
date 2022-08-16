package chap02;

import java.util.Scanner;

//배열 요소의 최댓값 구하기
class MaxOfArray {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");int size = scan.nextInt();
        int[] arr = new int[size];
        for(int i=0;i<size;i++){
            System.out.printf("height[%d] : ",i);arr[i] = scan.nextInt();
        }
        System.out.printf("최댓값은 %d입니다.\n",maxOf(arr));
    }
    static int maxOf(int[] arr){
        int max = arr[0];
        for(int n:arr){
            if (max < n) max = n;
        }
        return max;
    }
}
