package recursive;

// 8퀸
public class EightQueen {
    static int[] col = new int[8]; // 각 열의 퀸의 위치
    static boolean[] rowFlag = new boolean[8];
    static boolean[] diagFlag1 = new boolean[15]; // /
    static boolean[] diagFlag2 = new boolean[15]; // \

    public static void main(String[] args) {
        eightQueen(0);
    }

    // j : 행, i : 열
    static void eightQueen(int i){
        for (int j = 0; j < 8; j++) {
            // 가능한 퀸의 위치라면
            if (!rowFlag[j] && !diagFlag1[j + i] && !diagFlag2[j - i + 7]) {
                // 퀸 배치
                col[i] = j;
                rowFlag[j] = true;
                diagFlag1[j + i] = true;
                diagFlag2[j - i + 7] = true;
                if (i < 7) eightQueen(i + 1);
                // 든 열의 퀸을 채웠다면 출력
                else print();

                // 가능한 퀸을 다 채웠다면 flag를 리셋 후 다음 행에 퀸 배치
                rowFlag[j] = false;
                diagFlag1[j + i] = false;
                diagFlag2[j - i + 7] = false;
            }
        }
    }
    static void print(){
        for (int i:col) System.out.printf("%2d",i);
        System.out.println();
    }
}