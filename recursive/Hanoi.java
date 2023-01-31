package recursive;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");int n = scan.nextInt();

        // 1번에 있는 n개의 원반을 3으로 이동
        move(n,1,3);
    }

    // n개의 원반을 start에서 end로 옮김
    // 2. n-1개의 원판을 end로 마저 옮김
    static void move(int n, int start, int end){
        if (n > 0) {
            // n-1개의 원판을 start와 end를 제외한 다른 곳으로 옮긴 후,  n번 원판을 start에서 end로 옮김
            move(n-1, start, 6 - start - end);
            // n start -> end
            System.out.printf("%d번 원판을 %d번 째에서 %d번 째로 이동\n", n, start, end);
        }
        // start와 end를 제외한 다른 곳으로 옮긴 n-1개의 원판들을 end로 옮기는 작업
        if (n > 1) {
            move(n - 1, 6 - start - end, end);
        }
    }
}
