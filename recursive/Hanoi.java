package recursive;

import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");int n = scan.nextInt();

        // n개의 원반을 1에서 3으로 이동
        move(n,1,3);
    }

    // n개의 원반을 start에서 end로 옮김
    static void move(int n, int start, int end){
        if (n > 0){
            // 옮기고자하는 원반 위의 원반들을 다른 곳으로 이동
            move(n-1,start, 6 - end - start);
            System.out.printf("%d원반을 %d번째에서 %d번째로 이동\n",n,start,end);
        }

        // 마지막으로 옮긴 원반은 1원반이 되어야함
        if (n > 1)
            move(n-1,6 - start - end, end);
    }
}
