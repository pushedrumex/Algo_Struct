package chap01;

import java.util.Scanner;

// 1부터 n까지의 합
class sumWhile {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("1부터 n까지의 합을 구합니다.");
        int n;
        int a;
        do{
            System.out.print("n의 값 : ");
            n = scan.nextInt();
        } while (n <= 0);

        int temp = n;
        int sum = 0;
        while (temp > 0) sum += temp--;
        System.out.printf("1부터 %d까지의 합은 %d입니다.\n",n,sum);
    }
}
