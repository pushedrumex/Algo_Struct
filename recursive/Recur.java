package recursive;

import java.util.Scanner;

public class Recur {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");int n = scan.nextInt();
        recur(n);
    }
    static void recur(int n){
        if (n > 0){
            recur(n-1);
            System.out.println(n);
            recur(n-2);
        }
    }
}
