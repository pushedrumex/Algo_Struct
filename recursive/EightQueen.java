package recursive;

// 8퀸
public class EightQueen {
    static int[] col = new int[8];
    static boolean[] rowFlag = new boolean[8];
    static boolean[] diagFlag1 = new boolean[15]; // /
    static boolean[] diagFlag2 = new boolean[15]; // \
    static int N = 0;

    public static void main(String[] args) {
        eightQueen(0);
    }

    // i : 행, n : 열
    static void eightQueen(int n){
        for (int i = 0; i < 8; i++) {
            if (!rowFlag[i] && !diagFlag1[i + n] && !diagFlag2[i - n + 7]) {
                col[n] = i;
                rowFlag[i] = true;
                diagFlag1[i + n] = true;
                diagFlag2[i - n + 7] = true;
                if (n < 7) eightQueen(n + 1);
                else print();

                // 퀸을 다 채웠다면 flag를 리셋
                rowFlag[i] = false;
                diagFlag1[i + n] = false;
                diagFlag2[i - n + 7] = false;
            }
        }
    }
    static void print(){
        for (int i:col) System.out.printf("%2d",i);
        System.out.println();
    }
}