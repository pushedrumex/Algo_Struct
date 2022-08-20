package recursive;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : "); int n = scan.nextInt();
        System.out.printf("%d의 팩토리얼은 %d입니다.\n", n, factorial(n));
    }
    static int factorial(int n){
        if (n < 1) return 1;
        return n * factorial(n-1);
    }
}
