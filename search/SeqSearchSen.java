package search;
import java.util.Scanner;

// 선형검색
public class SeqSearchSen {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("요솟수 : "); int n = scan.nextInt();

        int[] arr = new int[n+1];
        for (int i = 0; i < n; i++) {
            System.out.printf("arr[%d] : ",i);
            arr[i] = scan.nextInt();
        }
        System.out.print("찾아야할 값 : ");int Num = scan.nextInt();

        int result = searchNum(arr,Num);
        if (result == -1) System.out.println("해당 요솟값이 존재하지 않습니다.");
        else System.out.printf("해당 요솟값은 arr[%d]에 존재합니다.\n",result);
    }
    static int searchNum(int[] arr, int Num){

        arr[arr.length-1] = Num; // 보초를 추가
        int i = 0;
        for (; i < arr.length; i++)
            if (arr[i] == Num) break;
        return i == arr.length-1 ? -1 : i;
    }
}