package sort;

public class Utils {

    // 출력
    static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }
    }

    // 교환
    static void swap(int[] arr,int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
