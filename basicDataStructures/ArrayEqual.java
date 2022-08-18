package basicDataStructures;

//두 배열이 같은지
public class ArrayEqual {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1,2,3,4,5};

        boolean result = isEqual(arr1,arr2);
        if (result) System.out.println("두 배열이 같습니다.");
        else System.out.println("두 배열이 다릅니다.");
    }
    static boolean isEqual(int[] arr1, int[] arr2){
        if (arr1.length != arr2.length) return false;
        for (int i=0;i<arr1.length;i++){
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
