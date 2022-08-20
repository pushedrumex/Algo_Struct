package recursive;

import java.util.Scanner;

// 유클리드 호제법을 사용하여 두 수의 최대 공약수 구하기
public class EuclidGCD {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");int n1 = scan.nextInt();
        System.out.print("정수를 입력하세요 : ");int n2 = scan.nextInt();

        System.out.printf("최대공약수는 %d입니다.\n", gcd(n1,n2));
    }
    static int gcd(int n1, int n2){
        if (n1%n2 == 0) return n2;
        return gcd(n2%n1, n1);
    }
}
